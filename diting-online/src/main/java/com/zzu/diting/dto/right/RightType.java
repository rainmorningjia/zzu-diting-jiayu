package com.zzu.diting.dto.right;

import lombok.Data;


public enum RightType {
    Copyright(1,"著作权"),
    ReputationRight(2,"名誉权/肖像权"),
    OtherRight(3,"其他权利");

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private Integer code;
    private String desc;
    RightType(Integer code,String desc){
        this.code=code;
        this.desc=desc;
    }
}
