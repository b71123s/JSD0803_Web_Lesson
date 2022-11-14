package cn.tedu.boot09.controller;

import cn.tedu.boot09.entity.Product;
import cn.tedu.boot09.mapper.ProductMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return ;
    }

    @RequestMapping("/select")
    public List<Product> select(){
        List<Product> list = mapper.select();
        // 把裝著Product對象的list集合直接響應給客戶端
        // 當返回值為list集合或是自定義對象，Spring MVC會自動將集合或對象轉換成JSON格式的字符串，再進行網路傳輸
        return  list;
    }

    @RequestMapping("/delete")
    public void delete(int id){
        System.out.println("id = " + id);
        mapper.deleteById(id);
    }

    @RequestMapping("/selectById")
    public Product selectById(int id) {
        //通过id查询商品的所有信息
        //SpringMVC框架发现返回值为自定义对象的时候会自动将对象转成
        //JSON格式的字符串后再进行传输
        return mapper.selectById(id);
    }
    @RequestMapping("/update")
    public void update(Product product){
        mapper.update(product);
    }

}
