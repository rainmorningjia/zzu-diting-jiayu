package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.right.RightDetailedDto;
import com.zzu.diting.dto.right.RightInfoDto;
import com.zzu.diting.dto.right.RightInfoListDto;
import com.zzu.diting.dto.right.RightManagerDto;
import com.zzu.diting.entity.CopyrightInfoPO;
import com.zzu.diting.entity.OtherRightInfoPO;
import com.zzu.diting.entity.ReputationPortraitInfoPO;
import com.zzu.diting.entity.RightVO;
import com.zzu.diting.service.UserRightInfoService;
import com.zzu.diting.util.DataObjectTransDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @Title: RightController
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/30--13:24
 */
@RestController
@RequestMapping("right")
public class RightController {
    @Resource
    private UserRightInfoService userRightInfoService;

    @RequestMapping("userRightInfo")
    public RightInfoListDto getRightListDto(Integer page, Integer rows, HttpServletRequest request) {
        RightInfoListDto rightInfoListDto = new RightInfoListDto();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        List<RightVO> listRightVOAll = userRightInfoService.getListRightVOAll(userId, page, rows, new Long("0"), System.currentTimeMillis());
        List<RightInfoDto> list = new ArrayList<>();
        list = DataObjectTransDto.populateList(listRightVOAll, list, RightInfoDto.class);
        for (RightInfoDto rightInfoDto :
                list) {
            if ("审核未通过".equals(rightInfoDto.getAuditResult())) {
                rightInfoDto.setReason(userRightInfoService.getReasonForFail(rightInfoDto.getId()));
            }
        }
        Integer totalNumber = userRightInfoService.getTotalNumber(userId, new Long("0"), System.currentTimeMillis());
        rightInfoListDto.setRightInfoDtoS(list);
        rightInfoListDto.setTotalNumber(totalNumber);
        return rightInfoListDto;
    }
    @RequestMapping("addUserRightInfo")
    public MessageDto addRightInfo(RightDetailedDto rightDetailedDto) {
        MessageDto messageDto = new MessageDto();
        try {
            String rightType = rightDetailedDto.getCopyrightType();
            String c = "著作权";
            String r = "名誉权/肖像权";
            String o = "其他权利";
            if (c.equals(rightType)) {
                CopyrightInfoPO copyrightInfoPO = new CopyrightInfoPO();
                DataObjectTransDto.populate(rightDetailedDto, copyrightInfoPO);
                userRightInfoService.addCopyrightInfo(copyrightInfoPO);
            }
            if (r.equals(rightType)) {
                ReputationPortraitInfoPO reputationPortraitInfoPO = new ReputationPortraitInfoPO();
                DataObjectTransDto.populate(rightDetailedDto, reputationPortraitInfoPO);
                userRightInfoService.addReputationPortraitInfo(reputationPortraitInfoPO);
            }
            if (o.equals(rightType)) {
                OtherRightInfoPO otherRightInfoPO = new OtherRightInfoPO();
                DataObjectTransDto.populate(rightDetailedDto, otherRightInfoPO);
                userRightInfoService.addOtherRightInfo(otherRightInfoPO);

            }
        } catch (Exception e) {
            messageDto.setCode(1);
            messageDto.setMessage(e.getMessage());
            return messageDto;
        }
        messageDto.setCode(0);
        messageDto.setMessage("添加成功");
        return messageDto;
    }
}
