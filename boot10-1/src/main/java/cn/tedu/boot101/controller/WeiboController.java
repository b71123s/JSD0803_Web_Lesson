package cn.tedu.boot101.controller;

import cn.tedu.boot101.entity.Weibo;
import cn.tedu.boot101.mapper.WeiboMapper;
import cn.tedu.boot101.entity.Weibo;
import cn.tedu.boot101.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeiboController {
    @Autowired
    WeiboMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody Weibo weibo){
        System.out.println("weibo = " + weibo);
        mapper.insert(weibo);
    }

    @RequestMapping("/select")
    public List<Weibo> select(){
        return mapper.select();
    }

}
