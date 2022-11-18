package com.progmod2.beadando.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    public List<Employee> employeeList;

    public List<Employee> getEmployeeList()
    {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList)
    {
        this.employeeList = employeeList;
    }
    public boolean delete(Long id) {

        var isRemoved = this.employeeList.removeIf(post -> post.getId().equals(id));

        return isRemoved;
    }
}