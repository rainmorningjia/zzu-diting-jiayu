package com.zzu.diting.service;


import com.zzu.diting.entity.UserComplaintInfoPO;

import java.util.List;

public interface UserComplaintService {
    String addComplaintInfo(UserComplaintInfoPO userComplaintInfoPO);

    String addComplaintsInfo(List<UserComplaintInfoPO> complaints);

    String deleteUserComplaintById(Long id);

    UserComplaintInfoPO getUserComplaint(Long id);

    UserComplaintInfoPO getUserComplaint(UserComplaintInfoPO userComplaintInfoPO);

    String updateUserComplaint(UserComplaintInfoPO userComplaintInfoPO);

    String getReasonFailByComplaintId(Long id);

    void recallUserComplaint(Long id);
    void resubmitUserCompliantInfo(UserComplaintInfoPO userComplaintInfoPO);

    Integer getTotalTotalNumberByPageAndTimeAndAll(Long userId, Long t1, Long t2);

    Integer getTotalNumberByAllRightAndState(Long userId, Long t1, Long t2, String processState);

    Integer getTotalNumberByRightAndAllState(Long userId, Long t1, Long t2, String rightType);

    Integer getTotalNumberByRightAndState(Long userId, Long t1, Long t2, String rightType, String processState);

    Integer getTotalNumberByUrlAndOneRightAndAllState(Long userId, String url, Long t1, Long t2, String rightType);

    Integer getTotalNumberByUrlAndAllRightAndAllState(Long userId, String url, Long t1, Long t2);

    Integer getTotalNumberByUrlAndAllRightAndOneState(Long userId, String url, Long t1, Long t2, String state);

    Integer getTotalNumberByUrlAndOneRightAndOneState(Long userId, String url, Long t1, Long t2, String state, String rightType);

    Integer getTotalNumberByNameAndAllRightAndAllState(Long userId, String name, Long t1, Long t2);

    Integer getTotalNumberByNameAndOneRightAndAllState(Long useId, String name, Long t1, Long t2, String rightType);

    Integer getTotalNumberByNameAndAllRightAndOneState(Long userId, String name, Long t1, Long t2, String state);

    Integer getTotalNumberByNameAndOneRightAndOneState(Long userID, String name, Long t1, Long t2, String state, String rightType);


    Integer getTotalNumberByRightIdAndAllRightAndAllState(Long userId, Long rightId, Long t1, Long t2);

    Integer getTotalNumberByRightIdAndOneRightAndAllState(Long useId, Long rightId, Long t1, Long t2, String rightType);

    Integer getTotalNumberByRightIdAndAllRightAndOneState(Long userId, Long rightId, Long t1, Long t2, String state);

    Integer getTotalNumberByRightIdAndOneRightAndOneState(Long userID, Long rightId, Long t1, Long t2, String state, String rightType);


}
