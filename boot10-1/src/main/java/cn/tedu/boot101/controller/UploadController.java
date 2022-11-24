package cn.tedu.boot101.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        System.out.println("pic = " + pic);
        //得到原始文件名   a.jpg
        String fileName = pic.getOriginalFilename();
        System.out.println(fileName);
        //得到文件名的后缀   .jpg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一文件名 UUID.randomUUID()得到一个由16进制组成的一个唯一标识符
        fileName = UUID.randomUUID()+suffix;
        System.out.println(fileName);
        //准备保存图片的文件夹路径
        String dirPath = "c:/files";
        File dirFile = new File(dirPath);
        //判断如果文件夹不存在 则创建
        if (!dirFile.exists()){
            dirFile.mkdirs();//创建文件夹
        }
        //准备文件的完整路径  d:/files/xxxxx.jpg
        String filePath = dirPath+"/"+fileName;
        //把图片保存到指定路径  异常抛出
        pic.transferTo(new File(filePath));
        //将上传成功的图片路径响应给客户端
        //响应的是网络路径(http://localhost:8080/xxx.jpg)
        // 并非磁盘路径(d:/files/xxxx.jpg)
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url){
        // url = /xxxx.jpg
        //删除指定路径的文件  d:/files/xxxx.jpg
        new File("c:/files"+url).delete();
    }
}
