1.项目结构
    root package结构：com.dudu
    应用启动类Application.java置于root package下，这样使用@ComponentScan注解的时候默认就扫描当前所在类的package
    实体（Entity）置于com.dudu.domain包下
    逻辑层（Service）置于com.dudu.service包下
    controller层（web）置于com.dudu.controller层包下
    static可以用来存放静态资源
    templates用来存放默认的模板配置路径

2.静态文件
    Spring Boot从classpath(resource)的以下目录
        /static
        /public
        /resources
        /META-INF/resources
    优先级顺序为：META-INF/resources > resources > static > public
    优先级修改配置
    # 默认值为 /**
    spring.mvc.static-path-pattern=/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/
    #可以根据需求修改
    spring.resources.static-locations=这里设置要指向的路径，多个使用英文逗号隔开

3.Thymeleaf模板引擎
    Thymeleaf最大的特点是能够直接在浏览器中打开并正确显示模板页面，而不需要启动整个Web应用。它的功能特性如下
    Spring MVC中@Controller中的方法可以直接返回模板名称，接下来Thymeleaf模板引擎会自动进行渲染
    模板中的表达式支持Spring表达式语言（Spring EL)
    表单支持，并兼容Spring MVC的数据绑定与验证机制
    注：Thymeleaf和FreeMaker默认不能共存，Thymeleaf会优先拦截请求