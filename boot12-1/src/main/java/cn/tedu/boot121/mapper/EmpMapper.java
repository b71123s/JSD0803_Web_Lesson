package cn.tedu.boot121.mapper;

import cn.tedu.boot121.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface EmpMapper {

    void insert(Emp emp);

    void inserts(ArrayList<Emp> list);

    int deleteById(int id);

    int deletes(ArrayList<Emp> list);

    void update(Emp emp);

    Emp selectById(int id);



}
