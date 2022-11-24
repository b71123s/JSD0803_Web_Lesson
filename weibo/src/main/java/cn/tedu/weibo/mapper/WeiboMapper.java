package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.WeiboDetailVO;
import cn.tedu.weibo.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeiboMapper {

    void insert(Weibo weibo);

    List<WeiboIndexVO> selectIndex();

    WeiboDetailVO selectById(int id);
}
