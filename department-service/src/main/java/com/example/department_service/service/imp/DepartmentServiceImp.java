package com.example.department_service.service.imp;

import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.exception.ResourceNotfound;
import com.example.department_service.mapper.DepartmentMapper;
import com.example.department_service.repository.DepartmentRepository;
import com.example.department_service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepartmentDTO> getAll() {
        return departmentRepository.findAll().stream()
                .map(department -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getOne(Integer id) {
//        return modelMapper.map(departmentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotfound("Không tồn tại ID: "+id)),DepartmentDTO.class);

        return DepartmentMapper.mapToDepartmentDto(departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại ID: "+id)));
    }
}
