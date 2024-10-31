package com.example.employee_service.mapper;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructs {

    EmployeeDTO mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDTO employeeDTO);
}
