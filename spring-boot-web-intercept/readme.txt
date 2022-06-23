1.SpringBoot 在默认情况下（不定义WebMvcConfigurerAdapter），静态资源映射以下目录：
      /static
      /public
      /resources
      /META-INF/resources
    优先级顺序为：META-INF/resources > resources > static > public
    前端可以通过：http://localhost:8080/drog.jpeg直接访问静态资源

2.通过WebMvcConfigurerAdapter类自定义目录
    registry.addResourceHandler("/**").addResourceLocations("classpath:/myStatic/");
    配置后，前端http://localhost:8080/drog.jpeg直接访问"myStatic"中的静态资源

3.通过配置文件自定义目录：
    # 默认值为 /**
    spring.mvc.static-path-pattern=
    # 默认值为 classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/
    spring.resources.static-locations=这里设置要指向的路径，多个使用英文逗号隔开，

4.Filter和Interceptor的比较
    Filter是servlet规范中定义的java web组件, 在所有支持java web的容器中都可以使用
    Filter和Filter Chain是密不可分的, Filter可以实现依次调用正是因为有了Filter Chain
    Interceptor不是servlet规范中的java web组件, 而是Spring提供的组件, 功能上和Filter差不多. 但是实现上和Filter不一样.