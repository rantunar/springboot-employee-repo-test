package com.employee.test.controller;

import java.util.Optional;

import com.employee.test.entity.EmployeeEntity;
import com.employee.test.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployeeDetails(@PathVariable Long id){
        Optional<EmployeeEntity> entity = employeeService.gEmployeeDetail(id);
        if(entity.isPresent()){
            return new ResponseEntity<>(entity.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
