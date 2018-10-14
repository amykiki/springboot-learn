package demo.configurations;

import demo.filters.MyFilter;
import demo.listeners.MyListener;
import demo.servlets.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ServletComponentScan(basePackages = "demo")
/**
 * 两种方式注册servlet，一种是在@Configuration类中注册bean ServletRegistrationBean
 * 还有一种是通过在servlet类上标记@WebServlet，并在@Configuration类中加注解@ServletComponentScan
 * 注意@ServletComponentScan默认扫描的是注解所在的包，因此如果servlet类和类不在同一个包，要加basePackages注明要找的包
 */
public class SpringMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/otherimg/**").addResourceLocations("classpath:/otherimg/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:D:/codeProject/git_repo/springboot-learn/img/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //增加html解析
        registry.viewResolver(viewResolver());
    }

    @Bean
    //注册servlet
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean myServlet = new ServletRegistrationBean();
        myServlet.addUrlMappings("/servlet/*");
        myServlet.setServlet(new MyServlet());
        return myServlet;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean myFilter = new FilterRegistrationBean();
        myFilter.setFilter(new MyFilter());
        myFilter.addUrlPatterns("/index/*");
        myFilter.addInitParameter("controller", "index");
        myFilter.setName("filterForIndex");
        return myFilter;
    }

    @Bean
    public ServletListenerRegistrationBean myServletListener() {
        ServletListenerRegistrationBean myListener = new ServletListenerRegistrationBean();
        myListener.setListener(new MyListener());
        myListener.setOrder(1);
        return myListener;
    }

    private InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }
}
