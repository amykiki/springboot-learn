package demo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyServlet.class);
    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("===Myservlet doGet===");
        resp.getWriter().write("Hello Visitors from Get!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("===Myservlet doPost===");
        PrintWriter out = resp.getWriter();
        String title = "the showMessage servlet";
        out.println("<html>"+
                "<body bgcolor=\"#FDF5E6\">\n" +
                "<h1 align=center>" + title + "</H1>");
        out.println("Hello Visitors from Post");
        out.println("</body></html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.servletConfig = config;
        LOGGER.info("===Myservlet Inited===");
    }

    @Override
    public void destroy() {
        super.destroy();
        LOGGER.info("===Myservlet Destroyed===");
    }
}
