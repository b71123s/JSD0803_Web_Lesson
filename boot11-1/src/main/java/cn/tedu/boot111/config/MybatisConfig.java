package cn.tedu.boot111.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot111.mapper")
public class MybatisConfig {
}
