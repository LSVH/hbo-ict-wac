package L2.P2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doCalculation")
public class doCalculation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String symbol = "+";
        double answer = 0;
        double primary = Double.valueOf(request.getParameter("primary"));
        double secondary = Double.valueOf(request.getParameter("secondary"));
        String action = request.getParameter("action");
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        if (action.equals("multiply")) {
            symbol = "x";
            answer = primary * secondary;
        } else if (action.equals("divide")) {
            symbol = ":";
            answer = primary / secondary;
        } else if (action.equals("substract")) {
            symbol = "-";
            answer = primary - secondary;
        } else {
            // Add in all other cases
            answer = primary + secondary;
        }

        pw.write("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>Response</title></head><body>" +
                primary + " " + symbol + " " + secondary + " = " + answer
                + "</body></html>");

        pw.flush();
    }
}
