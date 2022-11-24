package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.dto.UserLoginDTO;
import cn.tedu.coolshark.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO user, HttpSession session, HttpServletResponse response){
        System.out.println("user = " + user + ", session = " + session);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                if (user.getRem()){
                    Cookie c1 = new Cookie("username", user.getUsername());
                    Cookie c2 = new Cookie("password", user.getPassword());

                    c2.setMaxAge(60*60*24*30);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                session.setAttribute("user",u);
                return 1;
            }
            return 3;
        }
        return 2;
    }

    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session){
        System.out.println("session = " + session);
        return (UserVO) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }

}
