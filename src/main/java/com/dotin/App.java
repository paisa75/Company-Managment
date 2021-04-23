package com.dotin;

import com.dotin.dao.EmployeeDao;
import com.dotin.model.Employee;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        //  Employee employee = new Employee("parisa","hosseiny","p.hoseyni75@gmail.com","09034778494",25,2,3,"tehran");
        // Employee employee2 = new Employee("paria","hasani","p.hoseyni72@gmail.com","09034704402",25,2,3,"tehran");
        //  employeeDao.saveEmployee(employee);
        //  employeeDao.saveEmployee(employee2);

        List<Employee> employees = employeeDao.getAllEmployee();
        employees.forEach(e -> System.out.println(e.getName()));
    }
}
