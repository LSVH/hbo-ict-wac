package L6.controller;

import L6.model.L6BlogService;
import L6.model.L6ServiceProvider;
import L6.model.L6User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "L6PostServlet")
public class L6PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all data for the blog service
        L6BlogService service = L6ServiceProvider.getBlogService();

        L6User u = service.getLoggedInUser(request);
        if (u == null) {
            // Check if the user already logged in
            response.sendRedirect("index.jsp");

        } else if ("true".equals(request.getParameter("post"))) {
            // Prepare for logging in to the user
            String title = request.getParameter("title");
            String message = request.getParameter("message");

            boolean passed = !( "".equals(title) || "".equals(message) );

            request.setAttribute("errorTitle", "".equals(title) ? "Please enter a title for your post." : "");
            request.setAttribute("errorMessage", "".equals(message) ? "Please enter a message for your post." : "");

            if (passed) {
                // Add the post
                service.addPostForUser(title, message, u);

                // Serve the posts page
                response.sendRedirect("posts.jsp");
            } else {
                request.getRequestDispatcher("account.jsp").forward(request, response);
            }
        }
    }
}
