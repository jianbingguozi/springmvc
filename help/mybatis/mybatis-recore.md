#### 插入的同时获取id
```mybatis
@Insert("INSERT INTO users(name, age) VALUES (#{user.name},#{user.age});")
@Options(keyProperty = "user.id", useGeneratedKeys = true)
public abstract void insertUser(@Param("user") User user);
```