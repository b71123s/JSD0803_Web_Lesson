package cn.tedu.boot012.controller;


import cn.tedu.boot012.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user){
        return "註冊成功!"+user.toString();
    }
}
