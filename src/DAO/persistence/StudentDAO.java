package DAO.persistence;

import DAO.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO {

    private List<Student> selectStudents(String query) {
        List<Student> results = new ArrayList<Student>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int studId = dbResultSet.getInt(1);
                String nm = dbResultSet.getString(2);

                results.add(new Student(studId, nm));
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return results;
    }

    public List<Student> getAll() {
        return selectStudents("SELECT * FROM studenten");
    }

    public Student getById(int id) {
        List<Student> temp = selectStudents(
                "SELECT * FROM studenten WHERE studentnr = " + id);
        if (temp != null && temp.size() > 0) {
            return temp.get(0);
        } else {
            return null;
        }
    }

    public List<Student> getAllInKlas(int klasId) {
        return selectStudents("SELECT * FROM studenten WHERE klasnr = " + klasId);
    }
}