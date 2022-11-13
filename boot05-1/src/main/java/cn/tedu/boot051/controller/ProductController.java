package cn.tedu.boot051.controller;

import cn.tedu.boot051.entity.Product;
import cn.tedu.boot051.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProductController {
    //Autowired自動裝配註解, 此註解是Spring框架中提供的註解
        //此註解添加後是Spring框架和Mybatis框架結合到一起,創建了一個
        //接口的實現類,並且實例化了該實現類 並賦值給了mapper變量
    //實現類中實現了接口裡面的抽象方法(insert)
    //(required = false)告訴idea 這個mapper不是必須的，沒抱錯不用加
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String insert(Product product){  // 用類型接收是是spring框架提供，直接幫你封裝進去屬性
        mapper.insert(product);
        return "新增成功 <a href='/'>返回首頁</a>";
    }



}
