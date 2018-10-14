package demo.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Order(-1)
@WebListener
public class MyListener2 implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyListener2.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("=====MyListener2 Initialed=====");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("=====MyListener2 Destroyed=====");
    }
}
