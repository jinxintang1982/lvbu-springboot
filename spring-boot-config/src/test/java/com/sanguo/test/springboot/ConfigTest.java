package com.sanguo.test.springboot;

import com.sanguo.srpingboot.Application;
import com.sanguo.srpingboot.configuration.PriorityProperties;
import com.sanguo.srpingboot.configuration.TypeProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ConfigTest {
    @Autowired
    PriorityProperties priorityProperties;

    @Autowired
    TypeProperties typeProperties;

    @Test
    public void test() {
        System.out.println("-------"
                + typeProperties.getServerHost());
    }



}
