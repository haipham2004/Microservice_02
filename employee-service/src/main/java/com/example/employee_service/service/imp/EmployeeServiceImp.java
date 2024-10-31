package com.example.employee_service.service.imp;

import com.example.employee_service.dto.DepartmentDTO;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.exception.ResourceNotfound;
import com.example.employee_service.mapper.MapStructs;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.APIClient;
import com.example.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private static final Logger loggers= LoggerFactory.getLogger(EmployeeServiceImp.class);

    private EmployeeRepository employeeRepository;

    private MapStructs mapStructs;

    private ModelMapper modelMapper;

    private APIClient apiClient;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository, MapStructs mapStructs, ModelMapper modelMapper, APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.mapStructs = mapStructs;
        this.modelMapper = modelMapper;
        this.apiClient = apiClient;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        List<DepartmentDTO> departments = apiClient.getAll();

        Map<Integer, DepartmentDTO> departmentNameMap = new HashMap<>();
        for (DepartmentDTO department : departments) {
            departmentNameMap.put(department.getId(), department);
        }

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = mapStructs.mapToEmployeeDto(employee);
            employeeDTO.setDepartmentName(departmentNameMap.get(employee.getIdDepartment()).getDepartmentName());
            employeeDTO.setDepartmentCode(departmentNameMap.get(employee.getIdDepartment()).getDepartmentCode());
            employeeDTOs.add(employeeDTO);
        }

        return employeeDTOs;
    }


    @Override
//    @CircuitBreaker(name = "employee-service", fallbackMethod = "hardCodeResponse")
//    @Retry(name = "employee-service", fallbackMethod = "hardCodeResponse")
    public EmployeeDTO getOne(Integer id) {
        loggers.info("Onsteal11");
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại ID: " + id));
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        employeeDTO.setDepartmentName(apiClient.getOne(employee.getIdDepartment()).getDepartmentName());
        employeeDTO.setDepartmentCode(apiClient.getOne(employee.getIdDepartment()).getDepartmentCode());
        return employeeDTO;
    }

    // Phương thức fallback
    public EmployeeDTO hardCodeResponse(Integer id, Throwable e) {

        loggers.info("Onsteal22");
        // Tạo một EmployeeDTO với dữ liệu cố định
        EmployeeDTO fallbackEmployee = new EmployeeDTO();
        fallbackEmployee.setId(id);
        fallbackEmployee.setDepartmentName("Unknown");
        fallbackEmployee.setDepartmentCode("Unknown");

        return fallbackEmployee;
    }
}

