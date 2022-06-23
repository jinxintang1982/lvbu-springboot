package com.sanguo.springboot.intercept.intercepter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(Object.class);
    /**
     * 配置静态访问资源：在应用启动时运行一次，设置访问url与静态文件映射关系
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //访问路径： http://localhost:8080/img/drog.jpeg映射到myStatic目录
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/myStatic/");
    }


    /**
     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.htm页面了
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
        super.addViewControllers(registry);
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/toLogin","/login");
        super.addInterceptors(registry);
    }
}