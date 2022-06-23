package com.sanguo.test.springboot;

import com.sanguo.srpingboot.Application;
import com.sanguo.srpingboot.configuration.TypeConfigJava;
import com.sanguo.srpingboot.configuration.TypeKotlinComplex;
import com.sanguo.srpingboot.configuration.TypeProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJavaConfig {
    @Autowired
    TypeConfigJava typeProperties;

    @Autowired
    TypeKotlinComplex typeKotlinComplex;
    @Test
    public void testString() {
        System.out.println(typeKotlinComplex);
    }
}
