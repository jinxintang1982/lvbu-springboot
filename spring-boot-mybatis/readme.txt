1.在Application类上添加@MapperScan及扫描包的路径，则不用再mapper类上添加@Mapper注解
    @MapperScan("com.sanguo.mybatis.mapper")
    public class Application {}

2.Mapper接口通过@Autowired注入，在编辑情况下，无法找不到对应的bean，于是提示找不到对应bean的错误。但实际上项目是正常运行的。
可在IntelliJ IDEA -- preferences -- Inspections。在Spring Core -- Autowring for Bean Class 中，将Severity的级别由之前的error改成warning。


3.mapper.xml文件中的类型可以使用myBatis配置文件进行简化
    如：某mapper.xml中
        <delete id="delete" parameterType="java.lang.Integer" >
        可以定义
        mybatis-config.xml
        <configuration>
            <typeAliases>
                <typeAlias alias="Integer" type="java.lang.Integer" />
    并在application.properties中进行指定
    mybatis.config-locations=classpath:mybatis/mybatis-config.xml

4.mybatis可以接受Enum类型，但controller不行