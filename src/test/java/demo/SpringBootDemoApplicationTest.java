package demo;

import demo.controller.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author :  ZouShumin
 * @Project Name :  springboot-learn
 * @Package Name :  demo
 * @Description :
 * @Creation Date:  2018-09-30 14:34
 * --------  ---------  --------------------------
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    public void indexTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world Amy"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getByNameTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index/getByName").param("name", "小星星"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.姓名").value("小星星"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.工作").value("软件工程师"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getByNameTest2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/index/getByName").param("name", "小星星"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.姓名").value("小星星"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.工作").value("软件工程师"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getByIdAndNameTest() throws Exception {
        //注意 uri模板有中文参数，要指定编码格式，否则乱码
        mvc.perform(MockMvcRequestBuilders.get("/index/getByIdAndName/{id}/{name}", 999, "小星星").characterEncoding("UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(999))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("小星星"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.department").value("挖坑填坑部"))
                .andDo(MockMvcResultHandlers.print());
    }
}