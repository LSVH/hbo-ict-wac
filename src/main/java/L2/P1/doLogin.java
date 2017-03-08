package L2.P1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doLogin")
public class doLogin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("u");
        String pass = request.getParameter("p");
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        pw.write("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>Response</title></head><body>Hello " + name + ", nice password :D (we know: " + pass + ")</body></html>");

        pw.flush();
    }
}
