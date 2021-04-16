package com.dotin.servlets;

import com.dotin.dao.EmployeeDao;
import com.dotin.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ParisaServlet", urlPatterns = {"/parisa","/paria"})
public class ParisaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ////////////////////////
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee("parisa","hosseiny","p.hosseiny75@gmail.com","09034778494",25,1L,3L,"tehran");
        Employee employee2 = new Employee("parisa2","hosseiny2","p.hosseiny75@gmail.com","09034778494",25,1L,3L,"tehran");
        employeeDao.saveEmployee(employee);
        employeeDao.saveEmployee(employee2);

        List< Employee > employees = employeeDao.getEmployee();
        employees.forEach(e -> System.out.println(e.getName()));
        //////////////////////////////


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello my Dear. Servlet is working :) </h1>");
        out.flush();
    }
}
