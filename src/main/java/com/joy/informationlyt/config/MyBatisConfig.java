package com.joy.informationlyt.config;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

// 注意不是org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.joy.informationlyt.domain.mapper")
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return configuration -> {
            // 开启驼峰映射规则
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }
}
