package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.dto.UserRegDTO;
import cn.tedu.weibo.pojo.vo.UserVO;

public interface UserMapper {

    void insert(UserRegDTO user);

    UserVO selectByUsername(String username);

}
