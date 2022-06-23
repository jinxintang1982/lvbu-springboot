坑：
    1.使用Kotlin进行配置List和HashMap时，一定不要使用lateinit！！！

    2.空格决定层级,robot只能在第二层级：
    megvii:
       robot:
        如果@ConfigurationProperties(prefix = "megvii.person"),person有值
        如果@ConfigurationProperties(prefix = "person"),Person为空，这样用必须在配置文件中把person顶格写

    3.注入的class类中一定要用HashMap,不能使用Map，否则会报空指针

注：
1.application.properties 配置中文值的时候，读取出来的属性值会出现乱码问题。但是 application.yml 不会出现乱码问题。原因是，Spring Boot 是以 iso-8859 的编码方式读取 application.properties 配置文件。

2.spring boot会先后依次加载application.yml,application.properties,以及在application.yml中激活的yml配置文件；
优先级为application.properties覆盖application-?.yml覆盖application.yml

3.在application.yml中激活一个或多个active,例：application.yml
  	spring:
  	   profiles:
  	     active: dev,test

4.如果你使用的是1.5以前的版本，那么可以通过locations指定properties文件的位置，这样：
  @ConfigurationProperties(prefix = "config2",locations="classpath:test.properties")
  但是1.5版本后改用@Configuration和@PropertySource(“classpath:test.properties”)
    @Configuration
    @PropertySource(value = "classpath:test.properties")
    @ConfigurationProperties(prefix = "com.forezp")
    public class User {

    }
5.随机配置
    dudu.secret=${random.value}
    dudu.number=${random.int}
    dudu.bignumber=${random.long}
    dudu.uuid=${random.uuid}
    dudu.number.less.than.ten=${random.int(10)}
    dudu.number.in.range=${random.int[1024,65536]}

6.Jar包外配置文件优先级
application.properties和application.yml文件可以放在一下四个位置：
    外置，在相对于应用程序运行目录的/congfig子目录里。
    外置，在应用程序运行的目录里
    内置，在config包内
    内置，在Classpath根目录
    同样，这个列表按照优先级排序，也就是说，src/main/resources/config下application.properties覆盖src/main/resources下application.properties中相同的属性，如图：

7.还可以用spring.profiles.include来叠加profile
  	例：spring.profiles.include: proddb,prodmq


