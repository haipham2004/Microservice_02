package com.example.department_service.mapper;

import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDTO departmentDTO) {

        Department department =
                new Department(
                        departmentDTO.getId(),
                        departmentDTO.getDepartmentName(),
                        departmentDTO.getDepartmentDescription(),
                        departmentDTO.getDepartmentCode()
                );

        return department;
    }

    public static DepartmentDTO mapToDepartmentDto(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDTO;
    }
}
