package DAO.controller;

import DAO.domain.Klas;
import DAO.domain.Student;
import DAO.domain.service.SchoolService;
import DAO.domain.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class KlassenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public KlassenServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SchoolService service = ServiceProvider.getSchoolService();
        System.out.println("doGet() van de KlassenServlet");
        request.setAttribute("klassen", service.getAlleKlassen());
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/DAO/ShowKlassen.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("getAllStudents"));
        SchoolService service = ServiceProvider.getSchoolService();
        System.out.println("doPost() van de KlassenServlet");

        List<Student> lijst = service.getDeStudentenUitKlas(id);
        String s = null;
        if (lijst == null || lijst.isEmpty()) {
            s = "In deze klas zitten geen studenten";
        } else {
            Klas k = service.getKlasById(id);
            if (k != null) {
                s = "Dit zijn alle studenten uit klas " + k.getKlasCode() +
                        ": " + lijst;
            }
        }
        getServletContext().setAttribute("studentsList", s);
        System.out.println(lijst);
        response.sendRedirect("Klassen");
    }
}