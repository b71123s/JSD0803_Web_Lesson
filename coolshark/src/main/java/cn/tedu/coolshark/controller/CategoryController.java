package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.CategoryMapper;
import cn.tedu.coolshark.pojo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired(required = false)
    CategoryMapper mapper;

    @RequestMapping("/select")
    public List<Category> select(){
        return mapper.select();
    }

    @RequestMapping("/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }

    @RequestMapping("/insert")
    public List<Category> insert(String name){
        System.out.println("name = " + name);
        mapper.insert(name);
        return mapper.select();
    }

    @RequestMapping("/update")
    public void update(@RequestBody Category category){
        mapper.update(category);
    }
}