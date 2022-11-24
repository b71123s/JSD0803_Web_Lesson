package cn.tedu.boot121.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot121.mapper")
public class MybatisCofig {
}
