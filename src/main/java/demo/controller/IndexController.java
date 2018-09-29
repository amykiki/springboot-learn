package demo.controller;

import demo.modal.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping
    public String index() {
        return "hello world Amy";
    }

    @RequestMapping(value = "/getByName")
    public Map<String, String> getByName(@RequestParam String name) {
        Map<String, String> result = new HashMap<>();
        result.put("姓名", name);
        result.put("爱好", "阅读，编程");
        result.put("工作", "软件工程师");
        return result;
    }

    @RequestMapping(value = "/getById/{id}/{name}")
    public User getByIdAndName(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDepartment("挖坑填坑部");
        return user;
    }

}
