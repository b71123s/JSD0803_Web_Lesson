package cn.tedu.boot091.controller;

import cn.tedu.boot091.entity.Product;
import cn.tedu.boot091.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String select(Product product){
        mapper.insert(product);
        return "註冊成功";
    }

}
