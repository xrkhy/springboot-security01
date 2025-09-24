package com.hsh.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xrkhy
 * @date 2025/9/8 22:00
 * @description
 */
@Configuration
@MapperScan("com.hsh.mapper")
public class MybatisPlusConfig {
}
