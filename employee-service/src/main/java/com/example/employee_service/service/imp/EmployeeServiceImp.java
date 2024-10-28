package com.example.employee_service.service.imp;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.exception.ResourceNotfound;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream()
                .map((employee) ->modelMapper.map(employee,EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getOne(Integer id) {
        return modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại ID: "+id)),EmployeeDTO.class);
    }
}
