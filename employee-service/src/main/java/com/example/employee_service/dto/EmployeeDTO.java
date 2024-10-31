package com.example.employee_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(description = "EmployeeDto Response")
public class EmployeeDTO {
    @Schema(description = "Employee Id")
    private int id;
    @Schema(description = "Employee firstName")
    private String firstName;
    @Schema(description = "Employee lastName")
    private String lastName;
    @Schema(description = "Employee email")
    private String email;
    @Schema(description = "idDepartment Id")
    private int idDepartment;
    @Schema(description = "departmentName")
    private String departmentName;
    @Schema(description = "departmentCode")
    private String departmentCode;
}
