package com.employee.test.service;

import java.util.List;
import java.util.Optional;

import com.employee.test.entity.EmployeeEntity;
import com.employee.test.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<EmployeeEntity> gEmployeeDetail(Long id){
        return employeeRepository.findById(id);
    }

}
