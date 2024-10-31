package com.example.employee_service.rest;

import com.example.employee_service.dto.DepartmentDTO;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
@Tag(name="EmpolyeeRest",
description = "EmpolyeeRest-API")
public class EmployeeRest {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Retrieve all employees",
            description = "Fetches a list of all employees in the system."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved the list of employees."
    )
    @GetMapping("hien-thi")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @Operation(
            summary = "Retrieve employee by ID",
            description = "Fetches the details of an employee based on the provided ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved the employee details."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Employee not found for the given ID."
    )

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.getOne(id));
    }




}
