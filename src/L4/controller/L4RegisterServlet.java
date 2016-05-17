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

@WebServlet(name = "L4/RegisterServlet")
public class L4RegisterServlet extends HttpServlet {

    private ArrayList<User> users;

    public void init() throws ServletException {
        this.users = new ArrayList<User>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getSession().getServletContext();
        if (context.getAttribute("user") != null) {
            // Check if the user already logged in
            response.sendRedirect("welcome.jsp");

        } else if (request.getParameter("register").equals("true")) {
            // Prepare for logging in to the user
            String user = request.getParameter("user");
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");

            boolean passed  = !(
                    "".equals(user) ||
                    "".equals(name) ||
                    "".equals(mail) ||
                    "".equals(pass) ||
                    "".equals(pass2) ||
                    userExists(user) ||
                    !validatePassword(pass, pass2)
            );

            request.setAttribute("errorUser", "".equals(user) ? "Please enter an username." : "");
            request.setAttribute("errorUser", userExists(user) ? "That username is already taken." : "");

            request.setAttribute("errorName", "".equals(name) ? "Please enter your full name." : "");

            request.setAttribute("errorMail", "".equals(mail) ? "Please enter an email address." : "");

            request.setAttribute("errorPass", "".equals(pass) ? "Please enter a password." : "");
            request.setAttribute("errorPass", "".equals(pass2) ? "Please confirm the password." : "");
            request.setAttribute("errorPass", !validatePassword(pass, pass2) ? "The password confirmation invalid." : "");

            if (passed) {
                // Continue registering
                User u = new User(user, pass, name, mail);
                users.add(u);

                context.setAttribute("user", u);
                context.setAttribute("userList", users);

                response.addCookie(new Cookie("user", user));
                response.sendRedirect("welcome.jsp");
            } else {
                // Cancel the registration process
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }
        }
    }

    private boolean userExists(String user) {
        boolean passed = false;
        for (User u : users) {
            if (u.getUser().equals(user)) {
                passed = true;
            }
        }
        return passed;
    }

    private boolean validatePassword(String primary, String secondary) {
        return primary.equals(secondary);
    }
}
