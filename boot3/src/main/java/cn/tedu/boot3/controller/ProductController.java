package cn.tedu.boot3.controller;

import cn.tedu.boot3.entity.Product;
import cn.tedu.boot3.util.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class ProductController {
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Product product){
        System.out.println("product = " + product);
        try (Connection conn = DBUtils.getConn()){
            String sql = "insert into product values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setInt(2, product.getPrice());
            ps.setInt(3,product.getNum());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加完成!<a href='/'>返回首頁</a>";
    }


    @RequestMapping("/select")
    @ResponseBody
    public String select(){
        // 創建一個ArrayList，把創建出來商品對象裝進去
        ArrayList<Product> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn()){
            String sql = "select id,title,price,num from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(2);
                int price = rs.getInt(3);
                int num = rs.getInt(4);
                // 創建對象霸查詢到數據進行封裝
                Product p = new Product();
                p.setId(id);
                p.setTitle(title);
                p.setPrice(price);
                p.setNum(num);
                list.add(p);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border='1'>";
        html += "<caption>商品列表</caption>";
        html += "<tr><th>id</th><th>標題<th>價格</th><th>庫存</th><th>操作</th></tr>";

        for (Product p: list) {
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getTitle()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            html+="<td>"+p.getNum()+"</td>";
            html+="<td>"+"<a href='/delete?id="+p.getId()+"'>刪除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id){
        System.out.println("id = " + id);
        try (Connection conn = DBUtils.getConn()){
            String sql = "delete from product where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "刪除完成<a href='/select'>返回列表頁面</a>";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Product product){
        try (Connection conn = DBUtils.getConn()){
            System.out.println("product = " + product);
            String sql = "update product set title=?,price=?,num=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,product.getTitle());
            ps.setInt(2,product.getPrice());
            ps.setInt(3,product.getNum());
            ps.setInt(4,product.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "修改完成<a href='/select'>返回列表頁面</a>";
    }
}
