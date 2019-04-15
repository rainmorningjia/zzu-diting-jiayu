package com.zzu.diting;

import com.zzu.diting.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =DiTingOnlineCoreApplication.class)
public class DitingOnlineApplicationTests {
    @Resource
    UserService userService;
    @Test
    public void contextLoads() {
    }

}
