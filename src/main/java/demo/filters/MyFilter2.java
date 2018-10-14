package demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
@WebFilter(urlPatterns = {"/order/*"},
        filterName = "filterForOrder",
        initParams = {@WebInitParam(name = "controller", value = "order")})
public class MyFilter2 implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter2.class);
    private String controller;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("===MyFilter2 Init===");
        LOGGER.info("===MyFilter2 Name===:" + filterConfig.getFilterName());
        LOGGER.info("===MyFilter2 Param Controller===:" + filterConfig.getInitParameter("controller"));
        controller = filterConfig.getInitParameter("controller");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("===MyFilter2 Before Controller: " + controller);
        chain.doFilter(request, response);
        LOGGER.info("===MyFilter2 After Controller: " + controller);
    }

    @Override
    public void destroy() {
        LOGGER.info("===MyFilter2 Destroy===");
    }
}
