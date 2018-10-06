package demo.controller;

import demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    private static int count = 0;

    //每次服务重启，这个随机值都会变
    @Value("${learnboot.secret}")
    private String secret;
    @Value("${learnboot.number}")
    private int number;
    @Value("${learnboot.desc}")
    private String domainDesc;
    @Value("${env}")
    private String env;

    @RequestMapping
    public String index() {
        return "hello world Amy";
    }

    @RequestMapping(value = "/getByName")
    public Map<String, Object> getByName(@RequestParam String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("姓名", name);
        result.put("爱好", "阅读，编程");
        result.put("工作", "软件工程师");
        result.put("随机密码", secret);
        result.put("随机整数", number);
        result.put("网站描述", domainDesc);
        result.put("运行环境", env);
        result.put("当前时间", new Date());
        LOGGER.trace("==={} -- LOG TRACE MSG======",count);
        LOGGER.debug("==={} -- LOG DEBUG MSG======",count);
        LOGGER.info("==={} -- LOG INFO  MSG======",count);
        LOGGER.warn("==={} -- LOG WARN  MSG======",count);
        LOGGER.error("==={} -- LOG ERROR MSG======",count);
        count++;
        return result;
    }

    @RequestMapping(value = "/getByIdAndName/{id}/{name}")
    public User getByIdAndName(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        //server console打出的时间时区是当前时区，而网页上显示的时区是spring配置的时区
        //因此网页上要设置当前时区需要单独配置，参考application.properties的配置
        user.setDate(new Date());
        System.out.println(user.getDate());
        user.setDepartment("挖坑填坑部");
        return user;
    }

}
