package DAO.domain.service;

public class ServiceProvider {
    private static SchoolService schoolService = new SchoolService();

    public static SchoolService getSchoolService() {
        return schoolService;
    }
}
