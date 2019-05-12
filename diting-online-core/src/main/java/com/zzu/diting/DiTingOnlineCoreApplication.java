package com.zzu.diting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wb-jcy525678
 * @Data:Created in 下午18:57 2019/03/18
 */
@RestController
@SpringBootApplication
@MapperScan("com.zzu.diting.mappers")
public class DiTingOnlineCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiTingOnlineCoreApplication.class,args);
    }
    @RequestMapping("/")
    public String index(){
        return "helloword";
    }
}
