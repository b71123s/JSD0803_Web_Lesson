package cn.tedu.boot05.mapper;

import cn.tedu.boot05.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 註解作用:設置接口為映射接口，接口是供Mybatis框架生成JDBC
// 代碼依據，在接口中定義方法和SQL語句
@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    // 預設方法就是public，所以省略
    void insert(Product product);

    // 聲明返回值類型為list集合 mybatis框架生成JDBC代碼時會將查詢到的數據
    // 封裝到Product對象裡面, 並且把對象添加到一個list集合中,把集合return出來
    @Select("select id,title,price,num from product")
    List<Product> select();

    @Delete("delete from product where id = #{id}")
    void deleteById(int id);

    @Update("update product set title=#{title}, price=#{price}, num=#{num} where id=#{id}")
    void update(Product product);

}
