package L6.utils;

import L6.model.L6BlogService;
import L6.model.L6ServiceProvider;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class L6ServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        L6BlogService service = L6ServiceProvider.getBlogService();
        service.registerUser("user", "Name ,user", "user@name.com", "user");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
