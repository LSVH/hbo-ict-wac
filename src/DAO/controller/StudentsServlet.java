package DAO.controller;

import DAO.domain.Klas;
import DAO.domain.service.SchoolService;
import DAO.domain.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SchoolService service = ServiceProvider.getSchoolService();
        System.out.println("doGet() van de StudentsServlet");
        request.setAttribute("students", service.getAlleStudenten());
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/DAO/ShowStudents.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("klassenVanAss"));
        SchoolService service = ServiceProvider.getSchoolService();
        System.out.println("doPost() van de StudentsServlet");

        List<Klas> lijst = service.deKlassenVanAssistent(id);
        String s = null;
        if (lijst == null || lijst.isEmpty()) {
            s = "Deze student is geen student-assistent";
        } else {
            s = "Deze student assisteert in de klassen: " + lijst;
        }
        getServletContext().setAttribute("klassenList", s);
        System.out.println(lijst);
        response.sendRedirect("Students");
    }
}

