package cn.tedu.boot121;

import cn.tedu.boot121.entity.Emp;
import cn.tedu.boot121.mapper.EmpMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class Boot121ApplicationTests {

    @Autowired
    EmpMapper mapper;

    @Test
    void contextLoads() {
        Emp e = new Emp();
        e.setName("elijah");
        e.setSalary(50000);
        e.setJob("SE");
        mapper.insert(e);
    }

    @Test
    void t1(){
        Emp e = new Emp();
        e.setName("jom");e.setSalary(21000);e.setJob("HE");
        Emp e1 = new Emp();
        e1.setName("hen");e1.setSalary(75000);e1.setJob("HR");

        ArrayList<Emp> list = new ArrayList<>();
        list.add(e);
        list.add(e1);
        mapper.inserts(list);
    }

    @Test
    void t2(){
        mapper.deleteById(2);
    }

}
