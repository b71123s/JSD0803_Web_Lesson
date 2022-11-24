package cn.tedu.weibo1.controller;

import cn.tedu.weibo1.mapper.UserMapper;
import cn.tedu.weibo1.pojo.dto.UserLoginDTO;
import cn.tedu.weibo1.pojo.dto.UserRegDTO;
import cn.tedu.weibo1.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDTO user){
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2;
        }
        mapper.insert(user);
        return 1;
    }
    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO user, HttpSession session){
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername()) ;

        if (u!=null){
            System.out.println("u.getPassword()  "+u.getPassword());
            System.out.println("user.getPassword()  "+user.getPassword());
//             密碼相同返回登入
            if (u.getPassword().equals(user.getPassword())){
                session.setAttribute("user",u);
                return 1;
            }
//            密碼不同返回密碼錯誤
            return 2;
        }
        return 3; // 用戶尚未註冊
    }

    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session){
        return  (UserVO) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }
    @RequestMapping("/upload")
    //這個參數名pic要跟前面name設定一樣，並且一定接收不然會異常
    public String upload(MultipartFile pic) throws IOException {

        // 先看是否接收到文件
        System.out.println("pic = " + pic);
        // 獲取原始文件名 a.jpg
        String fileName = pic.getOriginalFilename();
        System.out.println("fileName = " + fileName);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        // UUID.randomUUID()，在同台電腦不會生成重複ID，由16進制組成
        fileName = UUID.randomUUID() + suffix;
        System.out.println("newFileName = " + fileName);

        // 創建一個路徑+file文件夾
        String dirpath = "c:/files";
        File dirFile = new File(dirpath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }

        // 組合起來創建一個文件完整圖片路徑
        String filePath = dirFile + "/" + fileName;

        // 將文件保存到此路徑
        pic.transferTo(new File(filePath));
        // 把圖片路徑return給客戶端
        return "/"+fileName ;


    }
}
