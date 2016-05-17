package L3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import L4.model.User;

@WebServlet(name = "L3/RegisterServlet")
public class L3RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("register").equals("true")) {
            boolean passed = true;

            String user = request.getParameter("user");
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");

            if ("".equals(user)) {
                request.setAttribute("errorUser", "Please enter an username. ");
                passed = false;
            }

            if ("".equals(name)) {
                request.setAttribute("errorName", "Please enter your full name. ");
                passed = false;
            }

            if ("".equals(mail)) {
                request.setAttribute("errorMail", "Please enter an email address. ");
                passed = false;
            }

            if ("".equals(pass)) {
                request.setAttribute("errorPass", "Please enter a password. ");
                passed = false;
            }

            if ("".equals(pass2)) {
                request.setAttribute("errorPass", "Please confirm the password. ");
                passed = false;
            }

            if (!PasswordsMatch(pass, pass2)) {
                request.setAttribute("errorPass", "The password confirmation vailed. ");
                passed = false;
            }

            RequestDispatcher rd = null;
            if (passed) {
                request.setAttribute("user", new User(user, pass, name, mail));
                rd = request.getRequestDispatcher("welcome.jsp");
            } else {
                rd = request.getRequestDispatcher("register.jsp");
            }
            rd.forward(request, response);
        }
    }

    private boolean PasswordsMatch(String primary, String secondary) {
        return primary.equals(secondary);
    }
}
