package com.zzu.diting.service;


import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.rightaudit.AddRightAuditQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditFormQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditTablesDto;

/**
 * @author wb-jcy525678
 */
public interface RightAuditService {
    /**
     * 查询认证审核表格信息
     *
     * @param rightAuditFormQueryParam 请求参数
     * @return 表格数据
     */
    RightAuditTablesDto getRightAuditTableInfo(RightAuditFormQueryParam rightAuditFormQueryParam);

    /**
     * 添加权利分配信息
     *
     * @param addRightAuditQueryParam 请求参数
     * @return 处理结果
     */
    MessageDto addRightAuditInfo(AddRightAuditQueryParam addRightAuditQueryParam);
}
