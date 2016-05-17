package L4.controller;

import L4.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "L4/LogoutServlet")
public class L4LogoutServlet extends HttpServlet {
    private ArrayList<User> users;

    public void init() throws ServletException {
        this.users = new ArrayList<User>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("true".equals(request.getParameter("logout"))) {
            ServletContext context = request.getSession().getServletContext();

            // Empty all cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    c.setValue("");
                    c.setPath("/");
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }

            // Empty user context
            context.removeAttribute("user");
        }
        response.sendRedirect("index.jsp");
    }
}
