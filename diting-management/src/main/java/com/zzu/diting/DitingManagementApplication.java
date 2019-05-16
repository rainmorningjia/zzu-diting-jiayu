package com.zzu.diting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.zzu.diting.mappers"})
public class DitingManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(DitingManagementApplication.class, args);
    }

}
