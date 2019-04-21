package com.zzu.diting.manager;

import com.zzu.diting.entity.ComplaintWorkInfoPO;
import com.zzu.diting.entity.ComplaintsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplaintWorkManager {
    void addComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO);

    void deleteComplaintWorkById(Long id);

    void updateComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO);

    ComplaintWorkInfoPO getComplaintWorkById(Long id);

    ComplaintWorkInfoPO getComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO);


}
