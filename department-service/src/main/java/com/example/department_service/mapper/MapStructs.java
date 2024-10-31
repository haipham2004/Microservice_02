package com.example.department_service.mapper;

import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructs {

   DepartmentDTO CustomEntityToDto(Department department);
}
