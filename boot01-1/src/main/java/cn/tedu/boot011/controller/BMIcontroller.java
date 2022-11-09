package cn.tedu.boot011.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIcontroller {
    @RequestMapping("/bmi")
    @ResponseBody
    public String BMI(double h,double w){
        double bmi = w/((h/100)*(h/100));
        if (bmi<18.5){
            return "體重過輕了";
        }
        if (bmi<24){
            return "體重波棒!";
        }
        if (bmi<28){
            return "體重威胖";
        }
        return "該減肥了!!!";
    }
}
