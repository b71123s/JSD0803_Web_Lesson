package cn.tedu.weibo.controller;


import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.pojo.dto.CommentDTO;
import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired(required = false)
    CommentMapper mapper;
    @RequestMapping("/insert")
    public int insert(@RequestBody CommentDTO comment, HttpSession session){
        System.out.println("comment = " + comment + ", session = " + session);
        UserVO user = (UserVO) session.getAttribute("user");
        if (user==null){
            return 2;
        }
        Comment c = new Comment();
        // 將小容器東西放到大容器內概念，將comment(兩個屬性)放到c(全部屬性)
        BeanUtils.copyProperties(comment,c);
        c.setUserId(user.getId());
        c.setCreated(new Date());
        mapper.insert(c);
        return 1;
    }

    @RequestMapping("/selectByWeiboId")
    public List<CommentVO> selectByWeiboId(int id){

        return mapper.selectByWeiboId(id);
    }
}
