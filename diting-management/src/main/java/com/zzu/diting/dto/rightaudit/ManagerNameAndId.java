package com.zzu.diting.dto.rightaudit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerNameAndId implements Serializable {
    private String name;
    private String id;
}
