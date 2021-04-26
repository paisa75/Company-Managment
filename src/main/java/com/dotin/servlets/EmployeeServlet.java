package com.dotin.servlets;

import com.dotin.dao.CategoryDao;
import com.dotin.dao.EmployeeDao;
import com.dotin.dao.VacationDAo;
import com.dotin.model.CategoryElement;
import com.dotin.model.Employee;
import com.dotin.model.Vacation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;
    private CategoryDao categoryDao;
    private VacationDAo vacationDAo;

    public void init() {
        employeeDao = new EmployeeDao();
        categoryDao = new CategoryDao();
        vacationDAo = new VacationDAo();
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
                case "/insertv":
                    insertVacation(request, response);
                    break;
                case "/vacation":
                    showNewVacationRequestForm(request, response);
                    break;
               /* case  "/checkVacation":
                    checkVacation(request,response);
                    break;*/
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
        request.setAttribute("roles", roles);
        List<Employee> manager = employeeDao.getAllmanager();
        request.setAttribute("manager", manager);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<CategoryElement> roles = categoryDao.getAllRoles();
        request.setAttribute("roles", roles);
        List<Employee> manager = employeeDao.getAllmanager();
        request.setAttribute("manager", manager);
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
        Long roleId = Long.parseLong(request.getParameter("role"));
        Long managerId = request.getParameter("managerId") != null ? Long.parseLong(request.getParameter("managerId")) : null;
        String address = request.getParameter("address");
        boolean isActive = request.getParameter("active") != null ? Boolean.parseBoolean(request.getParameter("active")) : false;

        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        newEmployee.setLastName(lastName);
        newEmployee.setEmail(email);
        newEmployee.setPhone(phone);
        newEmployee.setAge(age);
        newEmployee.setAddress(address);
        newEmployee.setActive(isActive);

        newEmployee.setRole(roleId != null ? categoryDao.getCategoryElement(roleId) : null);
        newEmployee.setManager(managerId != null ? employeeDao.getEmployee(managerId) : null);

        //newEmployee.setActive(true);

        employeeDao.saveEmployee(newEmployee
        );
        response.sendRedirect("list");
    }

    private void insertVacation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String fromDate = request.getParameter("from");
        String toDate = request.getParameter("to");
        String description = request.getParameter("description");
        Long userID = Long.parseLong(request.getParameter("userID"));
        Vacation vacation = new Vacation();
        vacation.setDescription(description);
        try {
            Date from = formatter6.parse(fromDate);
            Date to = formatter6.parse(toDate);
            vacation.setFrom(from);
            vacation.setTo(to);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Employee employee = employeeDao.getEmployee(userID);
        vacation.setPerson(employee);
        vacationDAo.saveVacation(vacation);
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Long roleId = Long.parseLong(request.getParameter("role"));
        Long managerId = request.getParameter("managerId") != null ? Long.parseLong(request.getParameter("managerId")) : null;
        String address = request.getParameter("address");
        Boolean isActive = request.getParameter("active") != null ? Boolean.parseBoolean(request.getParameter("active")) : false;
        ///Boolean isActive = request.getParameterValues("active");
        //Employee employee = new Employee();
        Employee employee = employeeDao.getEmployee(id);
        employee.setId(id);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setAge(age);
        employee.setAddress(address);
        employee.setActive(isActive);

        employee.setRole(roleId != null ? categoryDao.getCategoryElement(roleId) : null);
        employee.setManager(managerId != null ? employeeDao.getEmployee(managerId) : null);

        employeeDao.updateEmployee(employee);
        response.sendRedirect("list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Employee employee = employeeDao.getEmployee(id);
        employeeDao.deleteEmployee(employee);
        response.sendRedirect("list");
    }
  /*  private void checkVacation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Employee employee = employeeDao.getEmployee(id);
        employeeDao.deleteEmployee(employee);
        response.sendRedirect("list");
    }*/

    private void showNewVacationRequestForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacation-form.jsp");
        dispatcher.forward(request, response);
    }


}
