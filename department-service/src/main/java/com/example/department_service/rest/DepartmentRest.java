package com.example.department_service.rest;

import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.entity.Department;
import com.example.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentRest {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentRest(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List<DepartmentDTO>> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(departmentService.getOne(id));
    }
}
