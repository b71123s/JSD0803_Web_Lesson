package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.WeiboMapper;
import cn.tedu.weibo.pojo.dto.WeiboDTO;
import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.UserVO;
import cn.tedu.weibo.pojo.vo.WeiboDetailVO;
import cn.tedu.weibo.pojo.vo.WeiboIndexVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
public class WeiboController {

    @Autowired(required = false)
    WeiboMapper mapper;

    @RequestMapping("/weibo/insert")
    public int insert(HttpSession session, @RequestBody WeiboDTO weibo){
        UserVO u = (UserVO) session.getAttribute("user");
        if (u==null){
            for (String url: weibo.getUrls().split(",")){
                new File("c:/files"+url).delete();
            }
            return 2;
        }
        Weibo w = new Weibo();
        BeanUtils.copyProperties(weibo,w);
        w.setUserId(u.getId());
        w.setCreated(new Date());
        mapper.insert(w);
        return 1;
    }

    @RequestMapping("/weibo/select")
    public List<WeiboIndexVO> select(){
        return mapper.selectIndex();
    }

    @RequestMapping("/weibo/selectById")
    public WeiboDetailVO selectById(int id){
        return mapper.selectById(id);
    }

}
