package demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);
    private String controller;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("===MyFilter Init===");
        LOGGER.info("===MyFilter Name===:" + filterConfig.getFilterName());
        LOGGER.info("===MyFilter Param Controller===:" + filterConfig.getInitParameter("controller"));
        controller = filterConfig.getInitParameter("controller");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("===MyFilter Before Controller: " + controller);
        chain.doFilter(request, response);
        LOGGER.info("===MyFilter After Controller: " + controller);
    }

    @Override
    public void destroy() {
        LOGGER.info("===MyFilter Destroy===");
    }
}
