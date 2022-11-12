package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.Emp;
import cn.tedu.boot04.util.DBUtils;
import com.alibaba.druid.util.jdbc.PreparedStatementBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class EmpController {
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Emp emp){
        try (Connection conn = DBUtils.getConn()){
            System.out.println("emp = " + emp);
            String sql = "insert into myemp values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getName());
            ps.setInt(2,emp.getAge());
            ps.setString(3,emp.getJob());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "新增成功! <br><a href='/'>返回首頁</a>";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Emp emp){
        // 資料先查找有無此人性名 -> 有:驗證年齡  無:請先新增員工
        // 年紀 -> 正確:登入  錯誤:請重新輸入年紀
        try (Connection conn = DBUtils.getConn()){
            String sql = "select age from myemp where name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                // getInt將得到字符流轉成整數，因此用==比較
                if (rs.getInt(1)==emp.getAge()){
                    return "登入成功! <br><a href='/'>返回首頁</a>";
                }
                return "年齡從來不是秘密~ <br><a href='/'>返回首頁</a>";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "查無此人~ <br><a href='/'>返回首頁</a>";
    }

    @RequestMapping("/select")
    @ResponseBody
    public String select(Emp emp){
        System.out.println("emp = " + emp);
        ArrayList<Emp> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn()){
            String sql = "select id,name,age,job from myemp ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // 將所有查詢到的值列出
            while (rs.next()){
                // 每次都會得到id,name,age,job把它封裝成物件
                int id = rs.getInt(1);
                String name =rs.getString(2);
                int age =rs.getInt(3);
                String job =rs.getString(4);
                Emp e = new Emp();
                e.setId(id);
                e.setName(name);
                e.setAge(age);
                e.setJob(job);
                list.add(e);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border='1'>";
        html += "<caption>員工列表</caption>";
        html += "<tr><th>id</th><th>姓名<th>年齡</th><th>工作職位</th><th>操作</th></tr>";

        for (Emp e:list){
            html+="<tr>";
            html+="<td>"+e.getId()+"</td>";
            html+="<td>"+e.getName()+"</td>";
            html+="<td>"+e.getAge()+"</td>";
            html+="<td>"+e.getJob()+"</td>";
            html+="<td>"+"<a href='/delete?id="+e.getId()+"'>刪除</a></td>";
            html+="</tr>";
        }

        return html;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id){
        try (Connection conn = DBUtils.getConn()){
            String sql = "delete from myemp where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "刪除成功! <a href='/'>返回主頁</a>";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Emp emp){
        try (Connection conn = DBUtils.getConn()){
            System.out.println("emp = " + emp);
            String sql = "update myemp set name=?,age=?,job=? where id=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getName());
            ps.setInt(2,emp.getAge());
            ps.setString(3,emp.getJob());
            ps.setInt(4,emp.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "修改成功! <a href='/'>返回主頁</a>";
    }
}
