package demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticSourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/otherimg/**").addResourceLocations("classpath:/otherimg/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:D:/codeProject/git_repo/springboot-learn/img/");
    }
}
