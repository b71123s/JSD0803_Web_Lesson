package cn.tedu.boot06.mapper;

import cn.tedu.boot06.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into user values(null,#{username},#{password},#{nickname})")
    void insert(User user);

}
