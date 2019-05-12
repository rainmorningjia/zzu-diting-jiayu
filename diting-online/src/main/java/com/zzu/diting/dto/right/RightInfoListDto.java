package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightInfoListDto implements Serializable {
    private List<RightInfoDto> rows;
    private Integer total;
}
