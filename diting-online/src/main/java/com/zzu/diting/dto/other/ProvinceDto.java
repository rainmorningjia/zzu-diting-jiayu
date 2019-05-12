package com.zzu.diting.dto.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDto implements Serializable {
    private Integer id;
    private String code;
    private String name;
}
