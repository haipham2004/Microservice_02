package com.example.employee_service.dto;

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
public class EmployeeDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private int idDepartments;
}
