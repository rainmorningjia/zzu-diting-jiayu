package com.zzu.diting;

import com.zzu.diting.dto.complaint.UserComplaintNumberDto;
import com.zzu.diting.dto.right.RightNameAndIdDto;
import com.zzu.diting.entity.UserComplaintInfoPO;
import com.zzu.diting.manager.UserComplaintManager;
import com.zzu.diting.mapper.UserComplaintInfoMapper;
import com.zzu.diting.service.AddressSevice;
import com.zzu.diting.service.UserComplaintService;
import com.zzu.diting.service.UserRightInfoService;
import com.zzu.diting.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiTingOnlineCoreApplication.class)
public class DitingOnlineApplicationTests {
    @Resource
    UserRightInfoService userRightInfoService;
    @Resource
    AddressSevice addressSevice;
    @Resource
    UserComplaintInfoMapper userComplaintInfoMapper;
    @Resource
    UserComplaintService userComplaintService;

    @Test
    public void contextLoads() {
        addressSevice.queryAllProvice();
    }

    @Test
    public void testUserComplaint() {
        userComplaintInfoMapper.queryTotalNumberRightAndAllState(new Long("12345685"), new Long("0"), System.currentTimeMillis(), "名誉权/肖像权");
    }

    @Test
    public void testAddUserComplaint() {
        UserComplaintInfoPO userComplaintInfoPO = new UserComplaintInfoPO();
        userComplaintInfoPO.setUserId(new Long("12345678"));
        userComplaintInfoPO.setCopyrightType("其他权利");
        userComplaintInfoPO.setRelationRightId(new Long("100000012"));
        userComplaintInfoPO.setRightName("赵云");
        userComplaintInfoPO.setComplaintsUrl("http://www.zhaoyun.com;http://www.gawetest.com");
        userComplaintInfoPO.setComplaintPlatform("腾讯视频");
        UserComplaintNumberDto userComplaintNumberDto = userComplaintService.addComplaintInfo(userComplaintInfoPO);
        System.out.println(userComplaintNumberDto);
    }

    @Test
    public void getRightNameAndId() {
        List<RightNameAndIdDto> list = userRightInfoService.getRightNameAndIdDto("著作权", "测");
        for (RightNameAndIdDto r :
                list) {
            System.out.println(r);
        }
    }
}
