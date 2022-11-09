package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String BMI(double height,double weight){
        String result;
        double bmi = weight/((height/100)*(height/100));
        if (bmi<18.5){
            result = "您的BMI指數"+bmi+"，體重偏瘦!";
        }else if(bmi>18.5 && bmi<24){
            result = "您的BMI指數"+bmi+"，體重正常!";
        }else if (bmi>24 && bmi<28){
            result = "您的BMI指數"+bmi+"，體重微胖!";
        }else {
            result = "您的BMI指數"+bmi+"，超重瞜~~";
        }
        return result;
    }
}
