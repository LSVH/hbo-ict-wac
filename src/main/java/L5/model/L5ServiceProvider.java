package L5.model;

public class L5ServiceProvider {
    private static L5BlogService service = new L5BlogService();

    public static L5BlogService getBlogService() {
        return service;
    }
}
