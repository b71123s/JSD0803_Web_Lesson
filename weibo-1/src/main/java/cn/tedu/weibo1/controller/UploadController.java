package cn.tedu.weibo1.controller;

import cn.tedu.weibo1.mapper.UploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class UploadController {
    @Autowired
    UploadMapper mapper;
    @Value("c:/files")
    private String dirPath;

    @RequestMapping("/weibo/remove")
    public void remove(String url){
        new File(dirPath+url).delete();
    }


}
