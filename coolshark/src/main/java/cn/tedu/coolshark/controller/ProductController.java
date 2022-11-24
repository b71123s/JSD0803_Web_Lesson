package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDTO product){
        System.out.println("product = " + product);
        Product p = new Product();
        BeanUtils.copyProperties(product,p);

        p.setCreated(new Date());
        p.setViewCount(0);
        mapper.insert(p);
    }

    @RequestMapping("/select")
    public List<ProductAdminVO> select(){
        return mapper.selectForAdmin();
    }

    @Value("${dirPath}")
    private String dirPath;
    @RequestMapping("/delete")
    public void delete(int id){
        String url = mapper.selectUrlById(id);
        new File(dirPath+url).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("/selectForIndex")
    public List<ProductIndexVO> selectForIndex(){
        return mapper.selectForIndex();
    }

    @RequestMapping("/selectForTop")
    public List<ProductTopVO> selectForTop(){
        return mapper.selectForTop();
    }

    @RequestMapping("selectById")
    public ProductDetailVO selectById(int id){
        System.out.println("id = " + id);
        return mapper.selectById(id);
    }

    @RequestMapping("/selectByCid")
    public List<ProductIndexVO> selectByCid(int id){
        return mapper.selectByCid(id);
    }

    @RequestMapping("/selectByWd")
    public List<ProductIndexVO> selectByWd(String wd){
        return mapper.selectByWd(wd);
    }

    @RequestMapping("/selectForUpdateById")
    public ProductUpdateVO selectForUpdateById(int id){
        return mapper.selectForUpdateById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody ProductUpdateDTO product){
        System.out.println("product = " + product);
        mapper.update(product);

    }

}
