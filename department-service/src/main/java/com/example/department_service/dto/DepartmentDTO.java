package com.example.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DepartmentDTO {

    private int id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;

}
