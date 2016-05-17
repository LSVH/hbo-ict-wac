package DAO.domain;

import java.util.ArrayList;

public class Klas {
    private int klasId;
    private String klasCode;
    private ArrayList<Student> deStudenten = new ArrayList<Student>();
    private Student assistent;

    public Klas(int kId, String kC) {
        klasId = kId;
        klasCode = kC;
    }

    public void setAssistent(Student as) {
        assistent = as;
    }

    public Student getAssistent() {
        return assistent;
    }

    public void setKlasId(int kId) {
        klasId = kId;
    }

    public int getKlasId() {
        return klasId;
    }

    public void setKlasCode(String kC) {
        klasCode = kC;
    }

    public String getKlasCode() {
        return klasCode;
    }

    public void voegStudentToe(Student nwS) {
        if (!deStudenten.contains(nwS)) {
            deStudenten.add(nwS);
        }
    }

    public Student verwijderStudent(int sN) {
        Student exS = zoekStudent(sN);
        if (deStudenten.remove(exS)) {
            return exS;
        } else {
            return null;
        }
    }

    public Student zoekStudent(int sN) {
        for (Student s : deStudenten) {
            if (s.getStudentNummer() == sN) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> getDeStudenten() {
        return deStudenten;
    }

    public String toString() {
        return "KlasDAO: " + klasCode;
    }
}
