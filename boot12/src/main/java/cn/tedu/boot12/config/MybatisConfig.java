package cn.tedu.boot12.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot12.mapper")
public class MybatisConfig {

}
