package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.Product;
import cn.tedu.boot05.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 相當於在每個方法都添加@ResponseBody
@RestController
public class ProductController {
    // 註解會創建一個接口實現類，並實例化(new)該實現類，附值給mapper變量
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return "添加完成! <a href='/'>返回首頁</a>";
    }

    @RequestMapping("/select")
    public String select(){
        List<Product> list = mapper.select();
        String html = "<table border='1'>";
        html+="<caption>商品列表</caption>";
        html+="<tr><th>id</th><th>标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        //遍历集合 添加tr和td
        for (Product p:list) {
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getTitle()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            html+="<td>"+p.getNum()+"</td>";
            //添加删除超链接的一列, 请求地址为 /delete?id=xxx  ?是请求地址和参数的分隔符
            html+="<td><a href='/delete?id="+p.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;//把页面和数据一起返回给客户端
    }


    @RequestMapping("/delete")
    public String delete(int id){
        System.out.println("id = " + id);
        mapper.deleteById(id);
        return "刪除完成! <a href='/select'>返回列表頁面</a>";
    }

    @RequestMapping("/update")
    public String update(Product product){
        System.out.println("product = " + product);
        mapper.update(product);
        return "修改成功! <a href = '/select'>返回列表</a>";
    }

}
