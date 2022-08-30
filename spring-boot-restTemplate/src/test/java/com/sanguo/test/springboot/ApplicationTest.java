package com.sanguo.test.springboot;

import com.sanguo.springboot.utils.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTest {

    @Test
    public void contextLoads() {
        HttpUtil.post("","");
    }
}
