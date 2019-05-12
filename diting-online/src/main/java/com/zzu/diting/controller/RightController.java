package com.zzu.diting.controller;

import com.aliyun.oss.OSSClient;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.RightType;
import com.zzu.diting.dto.right.*;
import com.zzu.diting.entity.CopyrightInfoPO;
import com.zzu.diting.entity.OtherRightInfoPO;
import com.zzu.diting.entity.ReputationPortraitInfoPO;
import com.zzu.diting.entity.RightVO;
import com.zzu.diting.service.UserRightInfoService;
import com.zzu.diting.util.DataObjectTransDto;
import com.zzu.diting.util.FileUtil;
import com.zzu.diting.util.OSSClientUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
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
    public RightInfoListDto getRightListDto(Integer page, Integer rows, HttpServletRequest request, String rightType) {
        RightInfoListDto rightInfoListDto = new RightInfoListDto();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        List<RightVO> listRightVOAll = userRightInfoService.getListRightVOOneTypeAndAllState(userId, rightType, (page - 1) * rows, page * rows, new Long("0"), System.currentTimeMillis());
        List<RightInfoDto> list = new ArrayList<>();
        list = DataObjectTransDto.populateList(listRightVOAll, list, RightInfoDto.class);
        System.out.println(list);
        for (RightInfoDto rightInfoDto :
                list) {
            if ("审核未通过".equals(rightInfoDto.getAuditResult())) {
                rightInfoDto.setReason(userRightInfoService.getReasonForFail(rightInfoDto.getId()));
            }
        }
        Integer totalNumber = userRightInfoService.getTotalNumberByUserIDAndRightAndTypeAll(userId, new Long("0"), System.currentTimeMillis(), rightType);
        rightInfoListDto.setRows(list);
        rightInfoListDto.setTotal(totalNumber);
        return rightInfoListDto;
    }

    @ResponseBody
    @RequestMapping("addUserRightInfo")
    public MessageDto addRightInfo(RightDetailedDto rightDetailedDto, MultipartFile copyrightRegistrationFileUrlFile, MultipartFile certificatePositiveUrlFile, MultipartFile copyrightDocumentChainUrlFile, MultipartFile attorneyPowerUrlFile, MultipartFile proofMaterialUrlFile, MultipartFile intellctualPropertyCertificatesUrlFile, HttpServletRequest request) {
        System.out.println(rightDetailedDto);
        MessageDto messageDto = new MessageDto();
        OSSClient client = OSSClientUtil.getOSSClient();
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        Long userId = (Long) request.getSession().getAttribute("userId");
        rightDetailedDto.setUserId(userId);
        try {
            String rightType = rightDetailedDto.getCopyrightType();
            String c = "著作权";
            String r = "名誉权/肖像权";
            String o = "其他权利";
            if (copyrightRegistrationFileUrlFile != null) {
                String url = getUrl(copyrightRegistrationFileUrlFile, request, client, name);
                rightDetailedDto.setCopyrightRegistrationFileUrl(url);
            }
            if (certificatePositiveUrlFile != null) {
                String url = getUrl(certificatePositiveUrlFile, request, client, name);
                rightDetailedDto.setCertificatePositiveUrl(url);
            }
            if (copyrightDocumentChainUrlFile != null) {
                String url = getUrl(copyrightDocumentChainUrlFile, request, client, name);
                rightDetailedDto.setCopyrightDocumentChainUrl(url);
            }
            if (attorneyPowerUrlFile != null) {
                String url = getUrl(attorneyPowerUrlFile, request, client, name);
                rightDetailedDto.setAttorneyPowerUrl(url);
            }
            if (proofMaterialUrlFile != null) {
                String url = getUrl(proofMaterialUrlFile, request, client, name);
                rightDetailedDto.setProofMaterialUrl(url);
            }
            if (intellctualPropertyCertificatesUrlFile != null) {
                String url = getUrl(intellctualPropertyCertificatesUrlFile, request, client, name);
                rightDetailedDto.setIntellctualPropertyCertificatesUrl(url);
            }
            if (c.equals(rightType)) {
                CopyrightInfoPO copyrightInfoPO = new CopyrightInfoPO();
                DataObjectTransDto.populate(rightDetailedDto, copyrightInfoPO);
                copyrightInfoPO.setCopyrightType("著作权");
                userRightInfoService.addCopyrightInfo(copyrightInfoPO);
            }
            if (r.equals(rightType)) {
                ReputationPortraitInfoPO reputationPortraitInfoPO = new ReputationPortraitInfoPO();
                DataObjectTransDto.populate(rightDetailedDto, reputationPortraitInfoPO);
                reputationPortraitInfoPO.setCopyrightType("名誉权/肖像权");
                userRightInfoService.addReputationPortraitInfo(reputationPortraitInfoPO);
            }
            if (o.equals(rightType)) {
                OtherRightInfoPO otherRightInfoPO = new OtherRightInfoPO();
                DataObjectTransDto.populate(rightDetailedDto, otherRightInfoPO);
                otherRightInfoPO.setCopyrightType("其他权利");
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

    public String getUrl(Object object, HttpServletRequest request, OSSClient client, String name) throws Exception {
        MultipartFile multipartFile = (MultipartFile) object;
        File files1 = FileUtil.transerFile(multipartFile, request);
        String[] s1 = OSSClientUtil.uploadObject2OSS(client, files1, "zzu-diting", name);
        String url = OSSClientUtil.getUrl(client, "zzu-diting", s1[1]);
        return url;
    }

    @RequestMapping("getRightDetail")
    public RightDetailedDto getRightDetail(Long id, String type) {
        RightDetailedDto rightDetailedDto = new RightDetailedDto();
        String c = "著作权";
        String r = "名誉权/肖像权";
        String o = "其他权利";
        if (type.equals(c)) {
            CopyrightInfoPO copyrightInfoPO = userRightInfoService.getCopyrightInfoByRightId(id);
            DataObjectTransDto.populate(copyrightInfoPO, rightDetailedDto);

        }
        if (type.equals(r)) {
            ReputationPortraitInfoPO reputationPortraitInfoPO = userRightInfoService.getReputationPortraitInfoByRightId(id);
            DataObjectTransDto.populate(reputationPortraitInfoPO, rightDetailedDto);
        }
        if (type.equals(o)) {
            OtherRightInfoPO otherRightInfoPO = userRightInfoService.getOtherRightInfoByRightId(id);
            DataObjectTransDto.populate(otherRightInfoPO, rightDetailedDto);

        }
        return rightDetailedDto;
    }

    @RequestMapping("getRightIDAndName")
    public List<RightNameAndIdDto> getRightNameAndIdByNameAndRightType(RightNameAndType rightNameAndType) {
        List<RightNameAndIdDto> rightNameAndIdDto = userRightInfoService.getRightNameAndIdDto(rightNameAndType.getRightType(), rightNameAndType.getName());
        if (rightNameAndIdDto == null && rightNameAndType.getName().equals("")) {
            RightNameAndIdDto rightNameAndIdDto1 = new RightNameAndIdDto();
            rightNameAndIdDto1.setId(new Long(0));
            rightNameAndIdDto1.setName("");
            rightNameAndIdDto.add(rightNameAndIdDto1);
            return rightNameAndIdDto;
        } else {
            if (rightNameAndIdDto.size() == 0) {
                RightNameAndIdDto rightNameAndIdDto1 = new RightNameAndIdDto();
                rightNameAndIdDto1.setId(new Long(0));
                rightNameAndIdDto1.setName("");
                rightNameAndIdDto.add(rightNameAndIdDto1);
                return rightNameAndIdDto;
            } else {
                return rightNameAndIdDto;
            }
        }
    }

    @RequestMapping("getRightType")
    public List<RightType> getRightType() {
        List<RightType> list = new ArrayList<>();
        RightType rightType1 = new RightType(1, "著作权");
        RightType rightType2 = new RightType(2, "名誉权/肖像权");
        RightType rightType3 = new RightType(3, "其他权利");
        list.add(rightType1);
        list.add(rightType2);
        list.add(rightType3);
        return list;
    }

}
