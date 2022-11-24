package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.pojo.dto.UserLoginDTO;
import cn.tedu.weibo.pojo.dto.UserRegDTO;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDTO user){
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2;
        }
        mapper.insert(user);
        return 1;
    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO user, HttpSession session) {
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                // session裡面就類似我們常用的Map，是用{key:value , key:value}方式保存
                // 這個user類似個key，寫啥都可以，但要get拿的時候也要用這個user
                // u(是從數據庫拿出來的對象)，是要存進session的值
                // 每次調用都會自動內部生成新的session對象，不同用戶也不會搞混登入狀態
                session.setAttribute("user",u);
                return 1;
            }
            return 3;
        }
        return 2;
    }

    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session){
        // 拿到時後為Obj類型,轉userVO才可用
        return (UserVO) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }
}
