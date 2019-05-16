package com.zzu.diting;

import com.zzu.diting.conf.SpringUtil;
import com.zzu.diting.dto.authenticationwork.AuthenticationDetailFormDto;
import com.zzu.diting.dto.rightwork.RightWorkListDto;
import com.zzu.diting.dto.rightwork.RightWorkQueryParam;
import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import com.zzu.diting.entity.ManagerInfo;
import com.zzu.diting.mappers.AuthenticationDistributionManagementInfoMapper;
import com.zzu.diting.mappers.ComplaintWorkMapper;
import com.zzu.diting.mappers.ComplaintsWorkAllInfoMapper;
import com.zzu.diting.service.AuthenticationWorkService;
import com.zzu.diting.service.ManagerService;
import com.zzu.diting.service.RightWorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DitingManagementApplication.class)
public class DitingManagementApplicationTests {
    @Resource
    private ManagerService managerService;
    @Resource
    AuthenticationWorkService authenticationWorkService;
    @Resource
    RightWorkService rightWorkService;
    @Resource
    ComplaintsWorkAllInfoMapper complaintsWorkAllInfoMapper;
    @Resource
    ComplaintWorkMapper complaintWorkMapper;
    @Resource
    AuthenticationDistributionManagementInfoMapper authenticationDistributionManagementInfoMapper;

    @Test
    public void contextLoads() {
        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setName("贾晨雨");
        managerInfo.setAddress("河南省郑州市郑州大学北校区");
        managerInfo.setDepartment("测试");
        managerInfo.setEmail("jiachenyu@zzu.com");
        managerInfo.setNode("版权管理审核组");
        managerInfo.setPassword("123456");
        managerInfo.setSex("男");
        managerInfo.setSign("测试");
        managerInfo.setCreateTime(System.currentTimeMillis());
        managerInfo.setUpdateTime(System.currentTimeMillis());
        managerService.addManagerInfo(managerInfo);
    }

    @Test
    public void testAuthenticationWork() {
        AuthenticationDetailFormDto authenticationDetailFormDto = authenticationWorkService.getAuthenDetailInfoByWorkId(new Long("10000000"));
        System.out.println(authenticationDetailFormDto);
    }

    @Test
    public void testRightWork() {
        RightWorkQueryParam rightWorkQueryParam = new RightWorkQueryParam();
        rightWorkQueryParam.setSearchType(1);
        rightWorkQueryParam.setRightType(1);
        rightWorkQueryParam.setManagerId("100");
        rightWorkQueryParam.setTableType(1);
        rightWorkQueryParam.setTimeType(1);
        rightWorkQueryParam.setSortType(1);
        rightWorkQueryParam.setRowNumber(5);
        rightWorkQueryParam.setPageNumber(1);
        RightWorkListDto rightTable = rightWorkService.getRightTable(rightWorkQueryParam);
        System.out.println(rightTable);
    }

    @Test
    public void testSpringUtil() {
        ComplaintsWorkInfoPO complaintsWorkInfoPO=new ComplaintsWorkInfoPO();
        complaintsWorkInfoPO.setId(new Long(100021));
        complaintsWorkInfoPO.setProcessing(new Double("0.0"));
        System.out.println(complaintsWorkInfoPO);
        complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(complaintsWorkInfoPO);
    }
}
