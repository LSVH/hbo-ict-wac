package DAO.persistence;

import DAO.domain.Klas;
import DAO.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KlasDAO extends BaseDAO {
    private StudentDAO studentDAO = new StudentDAO();

    private List<Klas> selectKlassen(String query) {
        List<Klas> results = new ArrayList<Klas>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int klasId = dbResultSet.getInt(1);
                String cd = dbResultSet.getString(2);
                int assId = dbResultSet.getInt(3);

                Student assist = studentDAO.getById(assId);

                Klas nwK = new Klas(klasId, cd);
                nwK.setAssistent(assist);
                results.add(nwK);

                List<Student> lijst = studentDAO.getAllInKlas(klasId);
                for (Student s : lijst) {
                    nwK.voegStudentToe(s);
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return results;
    }

    public List<Klas> getAll() {
        return selectKlassen("SELECT * FROM KLASSEN");
    }

    public Klas getById(int klasId) {
        return selectKlassen("SELECT * FROM KLASSEN WHERE klasnr = " + klasId).get(0);
    }

    public List<Klas> deKlassenVanAssistent(int assId) {
        return selectKlassen("SELECT * FROM klassen WHERE assistent = " + assId);
    }
}