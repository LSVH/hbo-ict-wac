package L9.model;

public class ServiceProvider {
    private static L8.model.CountryService worldService = new L8.model.CountryService();

    public static L8.model.CountryService getWorldService() {
        return worldService;
    }
}