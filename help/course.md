### springmvc 的搭建过程
1. 使用maven模板搭建工程框架
```maven
    mvn archetype:generate -DgroupId=com.jianbingguozi.test -DartifactId=springmvc -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=fase -X
```
2. 按照个人喜好修改工程文档目录结构
```
.
├── help
│   └── course.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   │   │   └── config
│   │   └── webapp
│   │       ├── index.jsp
│   │       └── WEB-INF
│   │           └── web.xml
│   └── test
```
2. 修改pom文件添加springmvc环境
```pom
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.4.RELEASE</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.3.4.RELEASE</version>
    </dependency>
```
3. 整合springbean环境，基于注解配置