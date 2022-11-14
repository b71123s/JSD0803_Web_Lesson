package cn.tedu.boot08.mapper;

import cn.tedu.boot08.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user values(null,#{username},#{password},#{nickname})")
    void insert (User user);

    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);

}
