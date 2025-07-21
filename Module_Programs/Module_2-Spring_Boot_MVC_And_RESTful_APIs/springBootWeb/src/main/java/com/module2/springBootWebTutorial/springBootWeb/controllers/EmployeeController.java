package com.module2.springBootWebTutorial.springBootWeb.controllers;

import com.module2.springBootWebTutorial.springBootWeb.dto.EmployeeDTO;
import com.module2.springBootWebTutorial.springBootWeb.exceptions.ResourceNotFound;
import com.module2.springBootWebTutorial.springBootWeb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.findById(id);
        return employeeDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id " + id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String name) {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
        EmployeeDTO employeeDTO = employeeService.save(inputEmployee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long employeeId, @RequestBody @Valid EmployeeDTO inputEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, inputEmployee));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean deleted = employeeService.deleteEmployeeById(employeeId);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> patchEmployeeById(@PathVariable Long employeeId, @RequestBody Map<String, Object> updates) {
        EmployeeDTO employeeDTO = employeeService.patchEmployeeById(employeeId, updates);

        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
