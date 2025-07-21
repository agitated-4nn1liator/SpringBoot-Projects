package com.module2.springBootWebTutorial.springBootWeb.services;

import com.module2.springBootWebTutorial.springBootWeb.dto.EmployeeDTO;
import com.module2.springBootWebTutorial.springBootWeb.entities.EmployeeEntity;
import com.module2.springBootWebTutorial.springBootWeb.exceptions.ResourceNotFound;
import com.module2.springBootWebTutorial.springBootWeb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> findById(Long id) {
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO save(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO inputEmployee) {
        isExistsById(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEntity, EmployeeDTO.class);
    }

    public void isExistsById(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new ResourceNotFound("Employee not found with id " + employeeId);
        }
    }

    public boolean deleteEmployeeById(Long employeeId) {
        isExistsById(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO patchEmployeeById(Long employeeId, Map<String, Object> updates) {
        isExistsById(employeeId);

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}