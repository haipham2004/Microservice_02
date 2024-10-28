package com.example.employee_service.rest;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeRest {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.getOne(id));
    }
}
