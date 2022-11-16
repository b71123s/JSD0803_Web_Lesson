package cn.tedu.boot111;

import cn.tedu.boot111.entity.Product;
import cn.tedu.boot111.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot111ApplicationTests {
    @Autowired(required = false)
    ProductMapper mapper;


    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("紅玉紅茶");
        p.setPrice(50);
        p.setNum(10);
        mapper.insert(p);
    }

}
