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
### 搭建mybatis环境
1. 添加mybatis相关jir包
2. 创建mybatis配置文件
```myabatis
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://10.88.7.19:3306/mybatis01"/>
                <property name="username" value="root"/>
                <property name="password" value="pass10"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <package name="com.jianbingguozi.dao"/>
    </mappers>
</configuration>
```
3. 创建mapper数据库操作类
```java
public interface UserDao {
    @Select("select * from users where id = #{id}")
    public abstract User selectById(Integer id);
}
```
4. 构建sqlsession
```java
@Test
public void testSelect(){
    InputStream resourceAsStream = BaseDaoTest.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
    SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = build.openSession();
    UserDao userDao = sqlSession.getMapper(UserDao.class);
    User user = userDao.selectById(3);
    System.out.println(user);
}
```

### spring+mybatis整合
1. 增加spring-mabtis整个包
```maven
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis-spring</artifactId>
  <version>1.3.0</version>
</dependency>
```
2. 使用org.mybatis.spring.SqlSessionFactoryBean 整合
```spring
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="user" value="${username}"/>
    <property name="password" value="${password}"/>
    <property name="driverClass" value="${driver}"/>
    <property name="jdbcUrl" value="${url}"/>
</bean>
<!-- 需要配置数据源 -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
</bean>
```
3. 色泽mybatis部分属性，较少敢于mybatis 的原始xml配置文件
```spring
<!--设置mapper扫描路径-->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.jianbingguozi.dao"/>
</bean>
```
4. 报错需要引入spring关于数据相关的jir包
```maven
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-tx</artifactId>
  <version>4.3.4.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-jdbc</artifactId>
  <version>4.3.4.RELEASE</version>
</dependency>
```




[参考文档](http://www.cnblogs.com/sunniest/p/4555801.html)