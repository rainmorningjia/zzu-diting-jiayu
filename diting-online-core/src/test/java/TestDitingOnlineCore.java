import com.zzu.diting.DiTingOnlineCoreApplication;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
    @Test
    public void testUserInfo(){
        UserInfoPO userInfoPO=userInfoMapper.selectByPrimaryKey(new Long("12345678"));
    }
}
