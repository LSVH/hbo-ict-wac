package DAO.domain.service;

import DAO.domain.Klas;
import DAO.domain.Student;
import DAO.persistence.KlasDAO;
import DAO.persistence.StudentDAO;

import java.util.List;

public class SchoolService {
    private StudentDAO studentDAO = new StudentDAO();
    private KlasDAO klasDAO = new KlasDAO();

    public List<Student> getAlleStudenten() {
        return studentDAO.getAll();
    }

    public List<Klas> getAlleKlassen() {
        return klasDAO.getAll();
    }

    public List<Student> getDeStudentenUitKlas(int klasId) {
        Klas k = klasDAO.getById(klasId);
        if (k != null) {
            return k.getDeStudenten();
        }
        return null;
    }

    public List<Klas> deKlassenVanAssistent(int assId) {
        return klasDAO.deKlassenVanAssistent(assId);
    }

    public Klas getKlasById(int klasId) {
        return klasDAO.getById(klasId);
    }
}

