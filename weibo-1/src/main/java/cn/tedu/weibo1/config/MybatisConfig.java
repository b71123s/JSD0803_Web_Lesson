package cn.tedu.weibo1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.weibo1.mapper")
public class MybatisConfig {
}
