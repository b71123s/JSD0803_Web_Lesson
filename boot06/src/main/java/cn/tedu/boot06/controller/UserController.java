package cn.tedu.boot06.controller;

import cn.tedu.boot06.entity.User;
import cn.tedu.boot06.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user){ // 這個user是用戶輸入的
        System.out.println("user = " + user);
        // 這個u是資料庫查到的，不要搞混
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return "用戶已存在!";
        }
        mapper.insert(user);
        return "註冊成功! <a href='/'>返回首頁</a>";
    }

    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return "登入成功 <a href='/'>回到首頁</a>";
            }
            return "密碼錯誤 <a href='/login.html'>重新登入</a>";
        }
        return "用戶名不存在! <a href='login.html'>重新登入</a>";
    }


}
