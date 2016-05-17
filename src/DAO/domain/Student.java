package DAO.domain;

import java.time.LocalDate;

public class Student {
    private int studentNummer;
    private String naam;
    private LocalDate geboorteDatum;

    public Student(int sN, String nm) {
        studentNummer = sN;
        naam = nm;
        geboorteDatum = LocalDate.now();
    }

    public int getStudentNummer() {
        // TODO Auto-generated method stub
        return studentNummer;
    }

    public void setStudentNummer(int sN) {
        studentNummer = sN;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String nm) {
        naam = nm;
    }

    public void setGeboorteDatum(LocalDate geboren) {
        geboorteDatum = geboren;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public String toString() {
        return studentNummer + ": " + naam;
    }
}