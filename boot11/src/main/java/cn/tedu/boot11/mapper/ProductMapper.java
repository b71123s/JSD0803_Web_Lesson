package cn.tedu.boot11.mapper;

import cn.tedu.boot11.entity.Product;

import java.util.List;

//因为使用了MapperScan注解 所以这里不再写@Mapper注解
public interface ProductMapper {

    // 這裡不再用@Insert註解配置SQL語句，改寫在xml配置文件中
    void insert(Product product);

    List<Product> select();

    void deleteById(int id);

    void update(Product product);

    Product selectById(int id);


}
