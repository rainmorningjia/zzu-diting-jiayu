package com.zzu.diting.conf;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author :wb-jcy525678
 * @Description: 分配所有工单的启动类
 * @date : 2019/5/16 11:41
 */
@Component
public class MyDiTingCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) {
        DistributionRightWorkTask distributionRightWorkTask = new DistributionRightWorkTask();
        DistributionAuthenticationWorkTask distributionAuthenticationWorkTask = new DistributionAuthenticationWorkTask();
        DistributionComplaintWorkCopyrightTask distributionComplaintWorkTask = new DistributionComplaintWorkCopyrightTask();
        ComputerComplaintsWorkProcess computerComplaintsWorkProcess = new ComputerComplaintsWorkProcess();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("分配工单线程-pool-%d").build();
        ScheduledExecutorService scheduledExecutorService1 = new ScheduledThreadPoolExecutor(6, namedThreadFactory);
        ScheduledExecutorService scheduledExecutorService2 = new ScheduledThreadPoolExecutor(1, namedThreadFactory);
        ScheduledExecutorService scheduledExecutorService3 = new ScheduledThreadPoolExecutor(6, namedThreadFactory);
        ScheduledExecutorService scheduledExecutorService4 = new ScheduledThreadPoolExecutor(3, namedThreadFactory);
        scheduledExecutorService1.scheduleAtFixedRate(distributionRightWorkTask, 0, 30, TimeUnit.SECONDS);
        scheduledExecutorService2.scheduleAtFixedRate(distributionAuthenticationWorkTask, 0, 30, TimeUnit.SECONDS);
        scheduledExecutorService3.scheduleAtFixedRate(distributionComplaintWorkTask, 0, 30, TimeUnit.SECONDS);
        scheduledExecutorService4.scheduleAtFixedRate(computerComplaintsWorkProcess, 0, 30, TimeUnit.SECONDS);
    }
}
