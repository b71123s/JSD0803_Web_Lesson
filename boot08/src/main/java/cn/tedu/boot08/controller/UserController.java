package cn.tedu.boot08.controller;

import cn.tedu.boot08.entity.User;
import cn.tedu.boot08.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // 如果報錯在此註解後面加這行(required = false)
    @Autowired
    UserMapper mapper;

    // 如果發出的是異步請求，並且提交的參數是自定義對象，必須加入@RequestBody註解才能接收到數據
    @RequestMapping("/reg")
    public int reg(@RequestBody User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2;
        }
        mapper.insert(user);
        return 1;
    }

    @RequestMapping("/login")
    public int login(@RequestBody User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())) {
                return 1;  // 登入成功
            }
            return 3;  // 密碼錯誤
        }
        return 2;  // 用戶名不存在
    }

}
