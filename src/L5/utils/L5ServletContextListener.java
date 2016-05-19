package L5.utils;

import L5.model.L5BlogService;
import L5.model.L5ServiceProvider;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class L5ServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        L5BlogService service = L5ServiceProvider.getBlogService();
        service.registerUser("user", "Name ,user", "user@name.com", "user");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
