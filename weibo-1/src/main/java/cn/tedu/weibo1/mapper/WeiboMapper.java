package cn.tedu.weibo1.mapper;

import cn.tedu.weibo1.pojo.dto.WeiboDTO;
import cn.tedu.weibo1.pojo.entity.Weibo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeiboMapper {

    void insert(Weibo w);
}
