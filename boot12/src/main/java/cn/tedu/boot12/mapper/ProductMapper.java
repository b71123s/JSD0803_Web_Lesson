package cn.tedu.boot12.mapper;

import cn.tedu.boot12.entity.Product;

import java.util.List;

public interface ProductMapper {

    int count();

    int deleteByIds1(List<Integer> ids);
    int deleteByIds2(Integer[] ids);
    int deleteByIds3(Integer... ids);

    int insertProducts(List<Product> list);

    void dynamicUpdate(Product p);

    List<Product> select();
    Product selectById(int id);
}

