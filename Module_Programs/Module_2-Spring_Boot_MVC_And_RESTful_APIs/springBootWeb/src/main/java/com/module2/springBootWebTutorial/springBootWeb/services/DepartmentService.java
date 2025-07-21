package com.module2.springBootWebTutorial.springBootWeb.services;

import com.module2.springBootWebTutorial.springBootWeb.dto.DepartmentDTO;
import com.module2.springBootWebTutorial.springBootWeb.entities.DepartmentEntity;
import com.module2.springBootWebTutorial.springBootWeb.exceptions.ResourceNotFound;
import com.module2.springBootWebTutorial.springBootWeb.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = new ModelMapper();
    }

//    Check if the department exists
    public void isExistsById(Long id) {
        boolean exists = departmentRepository.existsById(id);
        if(!exists) {
            throw new ResourceNotFound("Department not found with id: " + id);
        }
    }

//    REST APIs:
//    GET: /departments - findAll
    public List<DepartmentDTO> findAllDepartments() {
        List<DepartmentEntity>  departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

//    GET: /departments/{id} - findById
    public Optional<DepartmentDTO> findDepartmentById(Long departmentId) {
        return departmentRepository
                .findById(departmentId)
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }

//    POST: /departments - save
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

//    PUT: /departments/{id} - update
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        isExistsById(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

//    DELETE: /departments/{id} - delete
    public boolean deleteDepartment(Long departmentId) {
        isExistsById(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }
}
