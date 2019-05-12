import com.zzu.diting.DiTingOnlineCoreApplication;
import com.zzu.diting.entity.Province;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.manager.UserComplaintManager;
import com.zzu.diting.mapper.ProvinceMapper;
import com.zzu.diting.mapper.UserComplaintInfoMapper;
import com.zzu.diting.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Miles
 * @Title: TestDitingOnlineCore
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/11--23:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DiTingOnlineCoreApplication.class)
public class TestDitingOnlineCore {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private ProvinceMapper provinceMapper;
    @Resource
    private UserComplaintInfoMapper userComplaintInfoMapper;
    @Resource
    UserComplaintManager userComplaintManager;

    @Test
    public void testUserInfo() {
        UserInfoPO userInfoPO = userInfoMapper.selectByPrimaryKey(new Long("12345678"));
    }

    @Test
    public void testProvince() {
        List<Province> list = provinceMapper.queryAllProvince();
    }

    @Test
    public void testUserComplaint() {
        userComplaintManager.getComplaintsRightAndAllState(new Long("12345685"), 0, 10, new Long("0"), System.currentTimeMillis(), "名誉权/肖像权");
    }
}
