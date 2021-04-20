package com.dotin.servlets;

import com.dotin.dao.CategoryDao;
import com.dotin.dao.EmployeeDao;
import com.dotin.model.CategoryElement;
import com.dotin.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;
    private CategoryDao categoryDao;

    public void init() {
        employeeDao = new EmployeeDao();
        categoryDao = new CategoryDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertEmployee(request, response);
                    break;
                case "/delete":
                    deleteEmployee(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = employeeDao.getAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CategoryElement> roles = categoryDao.getAllRoles();
        request.setAttribute("roles",roles);
        List<Employee> manager = employeeDao.getAllmanager();
        request.setAttribute("manager",manager);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<CategoryElement> roles = categoryDao.getAllRoles();
        request.setAttribute("roles",roles);
        List<Employee> manager = employeeDao.getAllmanager();
        request.setAttribute("manager",manager);
        Long id = Long.parseLong(request.getParameter("id"));
        Employee existingEmployee = employeeDao.getEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);

    }
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        int role = Integer.parseInt(request.getParameter("role"));
        int managerId = Integer.parseInt(request.getParameter("managerId"));
        String address = request.getParameter("address");


        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        newEmployee.setLastName(lastName);
        newEmployee.setEmail(email);
        newEmployee.setPhone(phone);
        newEmployee.setAge(age);
        newEmployee.setRole(role);
        newEmployee.setManagerId(managerId);
        newEmployee.setAddress(address);
        employeeDao.saveEmployee(newEmployee
        );
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        int role = Integer.parseInt(request.getParameter("role"));
        int managerId = Integer.parseInt(request.getParameter("managerId"));
        String address = request.getParameter("address");


        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setAge(age);
        employee.setRole(role);
        employee.setManagerId(managerId);
        employee.setAddress(address);
        employeeDao.updateEmployee(employee);
        response.sendRedirect("list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeDao.deleteEmployee(id);
        response.sendRedirect("list");
    }
}
