package cn.tedu.boot101.mapper;

import cn.tedu.boot101.entity.Weibo;
import cn.tedu.boot101.entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values(null,#{content},#{url})")
    void insert(Weibo weibo);

    @Select("select id,content,url from weibo")
    List<Weibo> select();



}
