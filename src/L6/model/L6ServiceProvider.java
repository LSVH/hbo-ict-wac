package L6.model;

public class L6ServiceProvider {
    private static L6BlogService service = new L6BlogService();

    public static L6BlogService getBlogService() {
        return service;
    }
}
