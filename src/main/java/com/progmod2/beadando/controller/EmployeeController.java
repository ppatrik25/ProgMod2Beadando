package com.progmod2.beadando.controller;

import java.net.URI;
import com.progmod2.beadando.model.Employee;
import com.progmod2.beadando.service.EmployeeService;
import com.progmod2.beadando.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController extends Employees {

    @Autowired
    private EmployeeService employeeList;

    @GetMapping(
            path = "/",
            produces = "application/json")

    public Employees getEmployees()
    {
        return employeeList.getAllEmployees();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Integer id = employeeList.getAllEmployees().getEmployeeList().size() + 1;

        employee.setId(id);

        employeeList.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();

        return new ResponseEntity<>("Employee added successfully.", HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) {
        employeeList.deleteEmployeeById(id);

        return new ResponseEntity<>("Employee deleted successfully.", HttpStatus.OK);
    }
}