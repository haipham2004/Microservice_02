package com.example.department_service.service;

import com.example.department_service.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> getAll();

    DepartmentDTO getOne(Integer id);
}
