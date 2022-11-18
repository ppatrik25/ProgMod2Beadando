package com.progmod2.beadando.service;

import com.progmod2.beadando.model.Employee;
import com.progmod2.beadando.model.Employees;
import org.springframework.stereotype.Repository;
import java.util.Objects;

@Repository

public class EmployeeService {
    private static Employees list = new Employees();


    static
    {
        list.getEmployeeList().add(new Employee(
                        1,                     //id
                        "Pelda",                  //firstName
                        "Valaki",                 //lastName
                        "pelda@gmail.com"));      //email
    }

    public Employees getAllEmployees()
    {
        return list;
    }
    public void addEmployee(Employee employee)
    {
        list.getEmployeeList().add(employee);
    }
    public void deleteEmployeeById(final Integer id)
    {
        list.getEmployeeList().removeIf(x -> Objects.equals(x.getId(), id));
    }
}
