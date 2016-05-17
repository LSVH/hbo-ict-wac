package L4.controller;

import L4.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "L4/LoginServlet")
public class L4LoginServlet extends HttpServlet {
    private ArrayList<User> users;

    public void init() throws ServletException {
        this.users = new ArrayList<User>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getSession().getServletContext();
        if (context.getAttribute("user") != null) {
            // Check if the user already logged in
            response.sendRedirect("welcome.jsp");

        } else if ("true".equals(request.getParameter("login"))) {
            // Prepare for logging in to the user
            String user = (String) request.getAttribute("user");
            String pass = (String) request.getAttribute("pass");

            boolean passed = userExists(user) || validatePassword(user, pass);

            request.setAttribute("errorUser", !userExists(user) ? "The username does not exists." : "");
            request.setAttribute("errorPass", !validatePassword(user, pass) ? "Incorrect password." : "");

            if (passed) {
                // Continue logging in
                context.setAttribute("user", searchUser(user));
                context.setAttribute("userList", users);

                response.addCookie(new Cookie("user", user));
                response.sendRedirect("welcome.jsp");
            } else {
                // Cancel the login process
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
    }

    private User searchUser(String user) {
        for (User u : users) {
            if (u.getUser().equals(user)) {
                return u;
            }
        }
        return null;
    }

    private boolean userExists(String user) {
        return searchUser(user) != null;
    }

    private boolean validatePassword(String user, String pass) {
        User u = searchUser(user);
        return u != null && u.checkPassword(pass);
    }

}
