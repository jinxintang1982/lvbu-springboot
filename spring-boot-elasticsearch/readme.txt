1.如果需要使用java程序访问9300端口，还需要将配置项：network.host: 0.0.0.0
	$ echo "network.host: 0.0.0.0" >> elasticsearch.yml
    原配置文件只有http.host: 0.0.0.0,所以只能通过Http访问

2.如果出现连不上的情况：无有效节点。先检查依赖包的版本；
    spring-boot-starter-data-elasticsearch中会包含org.elasticsearch.client:transport的版本
    可以通过Maven Project视图窗进行查看

3.如果不用SpringBoot整合
    2.1只需依赖包：
    <dependency>
        <groupId>org.elasticsearch</groupId>
        <artifactId>elasticsearch</artifactId>
        <version>${elasticsearch.version}</version>
    </dependency>

    <dependency>
        <groupId>org.elasticsearch.client</groupId>
        <artifactId>transport</artifactId>
        <version>${elasticsearch.version}</version>
    </dependency>

4.使用SpringBoot整合只需添加
    <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
    </dependency>