package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAll();

    EmployeeDTO getOne(Integer id);
}
