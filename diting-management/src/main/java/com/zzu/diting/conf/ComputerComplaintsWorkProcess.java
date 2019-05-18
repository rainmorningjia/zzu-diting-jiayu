package com.zzu.diting.conf;

import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import com.zzu.diting.mappers.ComplaintWorkMapper;
import com.zzu.diting.mappers.ComplaintsWorkAllInfoMapper;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class ComputerComplaintsWorkProcess implements Runnable {
    @Override
    public void run() {
        computer();
    }

    public void computer() {
        System.out.println("计算处理进度" + Thread.currentThread().getName());
        ComplaintsWorkAllInfoMapper complaintsWorkAllInfoMapper = SpringUtil.getBean(ComplaintsWorkAllInfoMapper.class);
        ComplaintWorkMapper complaintWorkMapper = SpringUtil.getBean(ComplaintWorkMapper.class);
        ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
        List<ComplaintsWorkInfoPO> list = complaintsWorkAllInfoMapper.selectAll();
        if (list.size() != 0) {
            for (ComplaintsWorkInfoPO c :
                    list) {
                Integer totalNumberWorksByWorksIdAndOneProcessing = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(c.getId(), "处理中", "AUDIT_STATE_ONE");

                float num = (float) (c.getComplaintNumber() - totalNumberWorksByWorksIdAndOneProcessing) / c.getComplaintNumber();
                DecimalFormat df = new DecimalFormat("0.00");
                Double dd = new Double(df.format(num));
                complaintsWorkInfoPO.setId(c.getId());
                complaintsWorkInfoPO.setProcessing(dd);
                complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(complaintsWorkInfoPO);
            }
        }

    }
}
