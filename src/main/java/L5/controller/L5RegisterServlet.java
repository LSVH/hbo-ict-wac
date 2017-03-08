package L5.controller;

import L5.model.L5BlogService;
import L5.model.L5ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "L5RegisterServlet")
public class L5RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all data for the blog service
        L5BlogService service = L5ServiceProvider.getBlogService();

        if (service.getLoggedInUser(request) != null) {
            // Check if the user already logged in
            response.sendRedirect("account.jsp");

        } else if ("true".equals(request.getParameter("register"))) {
            // Prepare for logging in to the user
            String user = request.getParameter("user");
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");

            // Define whenever to continue the registration
            boolean passed  = !(
                    "".equals(user) ||
                    "".equals(name) ||
                    "".equals(mail) ||
                    "".equals(pass) ||
                    "".equals(pass2) ||
                    service.searchUser(user) != null ||
                    !service.confirmPassword(pass, pass2)
            );

            // Display the error message when necessary
            request.setAttribute("errorUser", "".equals(user) ? "Please enter an username." : "");

            request.setAttribute("errorName", "".equals(name) ? "Please enter your full name." : "");

            request.setAttribute("errorMail", "".equals(mail) ? "Please enter an email address." : "");

            request.setAttribute("errorPass", "".equals(pass) ? "Please enter a password." : "");
            request.setAttribute("errorPass", "".equals(pass2) ? "Please confirm the password." : "");

            request.setAttribute("errorUser", service.searchUser(user) != null ? "That username is already taken." : "");
            request.setAttribute("errorPass", !service.confirmPassword(pass, pass2) ? "The password confirmation check failed." : "");

            if (passed) {
                // Submit the registration
                service.registerUser(user, name, mail, pass);

                // Create the cookies
                response.addCookie(new Cookie("user", user));
                response.addCookie(new Cookie("pass", pass));

                // Serve the account page
                response.sendRedirect("account.jsp");
            } else {
                // Cancel the registration process
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }
        }
    }
}
