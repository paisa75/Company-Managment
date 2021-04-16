package com.dotin;

import com.dotin.dao.EmployeeDao;
import com.dotin.model.Employee;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee("parisa","hosseiny","p.hosseiny75@gmail.com","09034778494",25,1L,3L,"tehran");
        Employee employee2 = new Employee("parisa2","hosseiny2","p.hosseiny75@gmail.com","09034778494",25,1L,3L,"tehran");
        employeeDao.saveEmployee(employee);
        employeeDao.saveEmployee(employee2);

        List< Employee > employees = employeeDao.getEmployee();
        employees.forEach(e -> System.out.println(e.getName()));
    }
}
