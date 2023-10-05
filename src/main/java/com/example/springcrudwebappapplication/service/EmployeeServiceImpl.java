package com.example.springcrudwebappapplication.service;

import com.example.springcrudwebappapplication.model.Employee;
import com.example.springcrudwebappapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository;


    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        repository.deleteById(id);
    }
}
