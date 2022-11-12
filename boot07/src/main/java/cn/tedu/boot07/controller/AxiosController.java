package cn.tedu.boot07.controller;

import cn.tedu.boot07.entity.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {

    @RequestMapping("/helloAxios")
    public String helloAxios(){
        return "測試成功";
    }

    @RequestMapping("/helloGet")
    public String helloGet(String info,int age){
        return "測試成功info="+info+"age="+age;
    }

    @RequestMapping("/helloPost")
    public String helloPost(@RequestBody Product product){
        return product.toString();
    }


}

