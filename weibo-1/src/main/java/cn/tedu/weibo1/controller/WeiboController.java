package cn.tedu.weibo1.controller;

import cn.tedu.weibo1.mapper.WeiboMapper;

import cn.tedu.weibo1.pojo.dto.WeiboDTO;
import cn.tedu.weibo1.pojo.entity.Weibo;
import cn.tedu.weibo1.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("/weibo")
public class WeiboController {
    @Autowired(required = false)
    WeiboMapper mapper;

    @Value("c:/files")
    private String dirPath;

    @RequestMapping("/insert")
    public int insert(HttpSession session, @RequestBody WeiboDTO weibo){
        System.out.println("session = " + session + ", weibo = " + weibo);
        // 獲取登入時保存的用戶對象
        UserVO u = (UserVO) session.getAttribute("user");

        // 沒有登入時刪除上傳成功的圖片
        if (u==null){
            // 刪除片力的每張圖片
            for (String url:weibo.getUrls().split(",")){
                new File(dirPath+url).delete();
            }
            // 返回2，未登入
            return 2;
        }

        // 有登入，把dto裡面數據裝進實體類中
        Weibo w = new Weibo();
        BeanUtils.copyProperties(weibo,w);
        // 設置微薄作者
        w.setUserId(u.getId());
        // 設置微薄的時間new Date() 得到的是当前的系统时间
        w.setCreated(new Date());
        // 保存到資料庫
        mapper.insert(w);
        // 返回1，成功
        return 1;
    }




}
