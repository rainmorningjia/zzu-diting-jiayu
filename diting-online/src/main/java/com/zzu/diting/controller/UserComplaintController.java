package com.zzu.diting.controller;

import com.zzu.diting.dto.complaint.UserComplaintInfoDto;
import com.zzu.diting.dto.complaint.UserComplaintListDto;
import com.zzu.diting.dto.complaint.UserComplaintNumberDto;
import com.zzu.diting.entity.UserComplaintInfoPO;
import com.zzu.diting.manager.UserComplaintManager;
import com.zzu.diting.service.UserComplaintService;
import com.zzu.diting.util.DataObjectTransDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("userComplaint")
public class UserComplaintController {
    @Resource
    UserComplaintService userComplaintService;

    @Resource
    UserComplaintManager userComplaintManager;

    @RequestMapping("getUserCompliant")
    public UserComplaintListDto getUserComplaintInfo(Integer page, Integer rows, HttpServletRequest request, String rightType) {

        UserComplaintListDto userComplaintListDto = new UserComplaintListDto();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        List<UserComplaintInfoDto> list = new ArrayList<>();
        List<UserComplaintInfoPO> list1 = userComplaintManager.getComplaintsRightAndAllState(userId, (page - 1) * rows, page * rows, new Long("0"), System.currentTimeMillis(), rightType);
        Integer toltaNumber = userComplaintService.getTotalNumberByRightAndAllState(userId, new Long("0"), System.currentTimeMillis(), rightType);
        DataObjectTransDto.populateList(list1, list, UserComplaintInfoDto.class);
        userComplaintListDto.setRows(list);
        userComplaintListDto.setTotal(toltaNumber);
        return userComplaintListDto;
    }

    @RequestMapping("addUserComplaintInfo")
    public UserComplaintNumberDto addUserComplaintInf(UserComplaintInfoDto userComplaintInfoDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        UserComplaintNumberDto userComplaintNumberDto = new UserComplaintNumberDto();
        userComplaintInfoDto.setUserId(userId);
        String  right=userComplaintInfoDto.getCopyrightType();
        if (right.equals("1")){
            userComplaintInfoDto.setCopyrightType("著作权");
        }
        if (right.equals("2")){
            userComplaintInfoDto.setCopyrightType("名誉权/肖像权");
        }
        if (right.equals("3")){
            userComplaintInfoDto.setCopyrightType("其他权利");
        }
        try {
            UserComplaintInfoPO userComplaintInfoPO = new UserComplaintInfoPO();
            DataObjectTransDto.populate(userComplaintInfoDto, userComplaintInfoPO);
            userComplaintNumberDto = userComplaintService.addComplaintInfo(userComplaintInfoPO);
            return userComplaintNumberDto;
        } catch (Exception e) {
            userComplaintNumberDto.setMessage("系统错误");
            userComplaintNumberDto.setCode(1);
            return userComplaintNumberDto;
        }

    }
}
