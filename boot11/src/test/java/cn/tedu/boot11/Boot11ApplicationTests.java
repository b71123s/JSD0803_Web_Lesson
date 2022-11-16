package cn.tedu.boot11;

import cn.tedu.boot11.entity.Product;
import cn.tedu.boot11.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Boot11ApplicationTests {

    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("阿薩姆紅茶");
        p.setPrice(3);
        p.setNum(100);
        mapper.insert(p);
    }

    @Test
    void t1(){
        List<Product> list = mapper.select();
        System.out.println(list);
    }

    @Test
    void t2(){
        mapper.deleteById(6);
    }

    @Test
    void t3(){
        Product p = new Product();
        p.setId(7);
        p.setTitle("醉心茗露");
        p.setPrice(7777);
        p.setNum(1);
        mapper.update(p);
    }

    @Test
    void t4(){
        Product p =  mapper.selectById(7);
        System.out.println(p.getTitle());
    }


}
