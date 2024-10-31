package com.example.employee_service.service;

import com.example.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="department-service", url = "http://localhost:8082")
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("department/hien-thi")
    List<DepartmentDTO> getAll();

    @GetMapping("department/{id}")
    DepartmentDTO getOne(@PathVariable("id") Integer id);
}
