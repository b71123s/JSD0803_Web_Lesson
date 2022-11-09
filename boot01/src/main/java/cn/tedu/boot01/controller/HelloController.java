package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
//    @RequestMapping("/hello")
//    public void hello(HttpServletResponse response) throws IOException {
//        // 設置響應類型
//        response.setContentType("text/html;charset=utf-8");
//        // 得到輸出對象  異常拋出
//        PrintWriter pw = response.getWriter();
//        // 給客戶端輸出響應內容
//        pw.println("恭喜你測試成功!");
//        // 關閉資源
//        pw.close();
//    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "恭喜你新註解註冊成功!!!";
    }
}
