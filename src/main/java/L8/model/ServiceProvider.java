package L8.model;

public class ServiceProvider {
    private static CountryService worldService = new CountryService();

    public static CountryService getWorldService() {
        return worldService;
    }
}