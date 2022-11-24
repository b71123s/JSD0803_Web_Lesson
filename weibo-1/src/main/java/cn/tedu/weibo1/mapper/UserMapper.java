package cn.tedu.weibo1.mapper;

import cn.tedu.weibo1.pojo.dto.UserRegDTO;
import cn.tedu.weibo1.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserVO selectByUsername(String username);

    void insert(UserRegDTO user);
}
