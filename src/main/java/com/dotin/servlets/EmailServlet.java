package com.dotin.servlets;

import com.dotin.dao.EmailDao;
import com.dotin.dao.EmployeeDao;
import com.dotin.dto.Inbox;
import com.dotin.model.Email;
import com.dotin.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmailServlet")
public class EmailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;
    private EmailDao emailDao;

    public void init() {
        employeeDao = new EmployeeDao();
        emailDao = new EmailDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {

            switch (action) {
                case "/Email":
                    showNewEmailForm(request, response);
                    break;
                case "/insertEmail":
                    insertEmail(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }

    private void showNewEmailForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Employee employee = employeeDao.getEmployee(id);

        List<Email> emails = emailDao.getEmailByReceiver(id);
        List<Inbox> inboxList = new ArrayList<>();
        for (Email email : emails) {
            Employee em = employeeDao.getEmployee(email.getSender());
            Inbox inbox = new Inbox();
            inbox.setDate(email.getDate());
            inbox.setEmail(em.getEmail());
            inbox.setName(em.getName());
            inbox.setLastName(em.getLastName());
            inbox.setId(email.getId());
            inbox.setMessage(email.getMessage());
            inbox.setSubject(email.getSubject());
            inboxList.add(inbox);
        }
        List<Email> Sendedemails = emailDao.getEmailBySender(id);
        List<Inbox> outboxList = new ArrayList<>();
        for (Email email : Sendedemails) {
            Employee em = employeeDao.getEmployee(email.getReceiver());
            Inbox inbox = new Inbox();
            inbox.setDate(email.getDate());
            inbox.setEmail(em.getEmail());
            inbox.setName(em.getName());
            inbox.setLastName(em.getLastName());
            inbox.setId(email.getId());
            inbox.setMessage(email.getMessage());
            inbox.setSubject(email.getSubject());
            outboxList.add(inbox);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("email-form.jsp");
        request.setAttribute("inboxList", inboxList);
        request.setAttribute("outboxList", outboxList);
        request.setAttribute("id", id);
        dispatcher.forward(request, response);
    }

    private void insertEmail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        //Long personId = Long.parseLong(request.getParameter("personId"));
        String receiver = request.getParameter("receiver");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        Email email = new Email();
        email.setSender(employeeDao.getEmployee(id).getId());
        email.setReceiver(employeeDao.getEmployeeByEmail(receiver).getId());
        email.setSubject(subject);
        email.setMessage(message);
        email.setDate(new Date());

        emailDao.saveEmail(email);
        response.sendRedirect("list");
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = employeeDao.getAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-employee.jsp");
        dispatcher.forward(request, response);
    }
}
