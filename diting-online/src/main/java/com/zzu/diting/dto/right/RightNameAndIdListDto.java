package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/25 19:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightNameAndIdListDto {
    private Integer code;
    private String message;
    List<RightNameAndIdDto> rightNameAndIdDtos;
}
