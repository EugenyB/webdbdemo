package com.te.webdbdemo;

import com.te.webdbdemo.beans.EmployeeBean;
import com.te.webdbdemo.dao.EmployeeDAO;
import com.te.webdbdemo.data.Employee;
import com.te.webdbdemo.db.ConnectionManager;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "*.html")
public class HelloServlet extends HttpServlet {
    private String message;
    private Connection connection;

    public void init() {
        message = "Hello World!";
        connection = ConnectionManager.getInstance().getConnection();
        if (connection != null) {
            message = "Database connected!";
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Employee> employees = new EmployeeDAO().findAll();
        request.setAttribute("empbean", new EmployeeBean(employees));
        request.getRequestDispatcher("/employee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int year = Integer.parseInt(request.getParameter("year"));
        Optional<Employee> e = new EmployeeDAO().findMaxByYear(year);
        if (e.isPresent()) {
            request.setAttribute("employee", e.get());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("null.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}