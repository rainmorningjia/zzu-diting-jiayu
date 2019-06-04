package com.zzu.diting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wb-jcy525678
 * @Data:Created in 下午18:57 2019/03/18
 */

@SpringBootApplication
@MapperScan("com.zzu.diting.mapper")
public class DiTingOnlineCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiTingOnlineCoreApplication.class,args);
    }
}
