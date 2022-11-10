package cn.tedu.boot02.controller;


import cn.tedu.boot02.entity.User;
import cn.tedu.boot02.util.DBUtils;
import com.alibaba.druid.util.jdbc.PreparedStatementBase;
import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user){
        System.out.println("user = " + user);
        try (Connection conn = DBUtils.getConn()){
            String sql = "insert into user values(null,?,?,?)";
            // sql放進預執行
            PreparedStatement ps = conn.prepareStatement(sql);
            // 接收預執行要使用的參數
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            // 正式執行
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "註冊成功";
    }


    @RequestMapping("/login")
    @ResponseBody
    public String login(User user){
        System.out.println("user = " + user);
        try (Connection conn = DBUtils.getConn()){
            String sql = "select password from user username where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            // rs.getString(1)  sql拿到的第一個字段(密碼)的值
            // user.getPassword()  用戶輸入的密碼(form傳過來參數)
            ResultSet rs = ps.executeQuery();
            // 判斷是否查詢到數據
            if (rs.next()){
                // 對照兩個密碼是否相同
                if (rs.getString(1).equals(user.getPassword())){
                    return "登入成功";
                }
                return "密碼錯誤!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 若連用戶都查不到返回不存在
        return "用戶名不存在!";
    }
}
