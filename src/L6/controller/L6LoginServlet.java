package L6.controller;

import L6.model.L6BlogService;
import L6.model.L6ServiceProvider;
import L6.model.L6User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "L6LoginServlet")
public class L6LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all data for the blog service
        L6BlogService service = L6ServiceProvider.getBlogService();

        if (service.getLoggedInUser(request) != null) {
            // Check if the user already logged in
            response.sendRedirect("account.jsp");

        } else if ("true".equals(request.getParameter("login"))) {
            // Prepare for logging in to the user
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");

            // Get the user object if the user exists
            L6User possibleUser = service.searchUser(user);

            // Check if we're set to login
            boolean passed = false;

            // Display the error message when necessary
            if (possibleUser == null) {
                request.setAttribute("errorUser", "The username \""+user+"\" does not exists.");
            } else {
                passed = possibleUser.checkPassword(pass);
                request.setAttribute("errorPass", passed ? "Incorrect password." : "");
            }

            if (passed) {
                // Continue logging in
                L6User u = service.loginUser(user, pass);

                // Create the cookies
                response.addCookie(new Cookie("user", user));
                response.addCookie(new Cookie("pass", pass));

                // Serve the account page
                response.sendRedirect("account.jsp");
            } else {
                // Cancel the login process
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

}
