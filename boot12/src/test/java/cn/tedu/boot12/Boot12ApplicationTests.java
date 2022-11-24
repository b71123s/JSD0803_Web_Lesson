package cn.tedu.boot12;

import cn.tedu.boot12.entity.Product;
import cn.tedu.boot12.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.ResultSet;
import java.util.ArrayList;

@SpringBootTest
class Boot12ApplicationTests {
    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.count());
    }

    @Test
    void t1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        int row = mapper.deleteByIds1(list);
        System.out.println("成功刪除:"+row+"行");
    }

    @Test
    void t2(){
        Integer[] ids = {12,13};
        int row = mapper.deleteByIds2(ids);
        System.out.println("成功刪除:"+row+"行");
    }

    @Test
    void t3(){
        int row = mapper.deleteByIds3(19);
        System.out.println("成功刪除:"+row+"行");
    }

    @Test
    void t4(){
        Product p1 = new Product();
        p1.setTitle("羽球");p1.setPrice(30);p1.setNum(2500);
        Product p2 = new Product();
        p2.setTitle("飄移版");p2.setPrice(1500);p2.setNum(777);

        ArrayList<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        int row = mapper.insertProducts(list);
        System.out.println("成功新增:"+row+"個物件");
    }

    @Test
    void t5(){
        Product p = new Product();
        p.setId(21);
        p.setTitle("青花瓷");
        mapper.dynamicUpdate(p);
    }

    @Test
    void t6(){
        Product p = mapper.selectById(21);
        System.out.println("查詢結果: "+p.toString());

        System.out.println("查詢所有結果: "+mapper.select());
    }

}
