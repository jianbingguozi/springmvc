## springmvc 的搭建过程
### 搭建spring
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

- 创建spring配置文件
- 在需要注入容器中的类上加上相应注解
- 创建spring核心容器applicationContext
- 从容器中获取想要的类
### 搭建springmvc（mvc）
1. 创建springmvc 的配置文件
```youtrack
/// 基本配置
<!--扫描controller包-->
<context:component-scan base-package="com.jianbingguozi.web"/>

<!--不处理静态资源-->
<mvc:default-servlet-handler/>

<!--开启mvc注解-->
<mvc:annotation-driven/>

<!--配置试图窄化器-->
<bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <!--前缀-->
    <property name="prefix" value="/WEB-INF/jsp/" />
    <!--后缀-->
    <property name="suffix" value=".jsp" />
</bean>
```
2. 修改web.xml文件
```
加载springmvc容器
<!--配置springmvc的过滤器-->
<servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:config/springmvc-servlet.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```
3. 编写controller
```
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(Model model){
        System.out.println("======================");
        return "login";
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("--------=-=-=-=-=-=--=----------------");
    }
}
```

[参考文档](http://www.cnblogs.com/sunniest/p/4555801.html)