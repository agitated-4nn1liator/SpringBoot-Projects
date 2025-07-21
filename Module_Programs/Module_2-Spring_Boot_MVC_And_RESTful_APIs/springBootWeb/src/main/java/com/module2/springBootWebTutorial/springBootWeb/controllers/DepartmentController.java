package com.module2.springBootWebTutorial.springBootWeb.controllers;

import com.module2.springBootWebTutorial.springBootWeb.dto.DepartmentDTO;
import com.module2.springBootWebTutorial.springBootWeb.exceptions.ResourceNotFound;
import com.module2.springBootWebTutorial.springBootWeb.repositories.DepartmentRepository;
import com.module2.springBootWebTutorial.springBootWeb.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    REST APIs
//    GET: /departments - findAll
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

//    GET: /departments/{id} - findById
    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId) {
        Optional<DepartmentDTO> departmentDTO = departmentService.findDepartmentById(departmentId);
        return departmentDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFound("Department not found with id " + departmentId));
    }

//    POST: /departments - save
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        DepartmentDTO savedDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
    }

//    PUT: /departments/{id} - update
    @PutMapping("/{departmentId}")
    public  ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable Long departmentId, @RequestBody @Valid DepartmentDTO departmentDTO) {
        DepartmentDTO updatedDTO = departmentService.updateDepartment(departmentId, departmentDTO);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }

//    DELETE: /departments/{id} - delete
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean>  deleteDepartmentById(@PathVariable Long departmentId) {
        boolean deleted = departmentService.deleteDepartment(departmentId);
        if(!deleted) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(true);
    }

}
