package com.te.webdbdemo.dao;

import com.te.webdbdemo.data.Employee;
import com.te.webdbdemo.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    public List<Employee> findAll() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Employee> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "select \"EmployeeId\" as id, \"LastName\" as lastname, \"FirstName\" as firstname, \"Title\" as title from \"Employee\"");
            while (rs.next()) {
                int employeeId = rs.getInt("id");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String title = rs.getString("title");
                Employee employee = new Employee(employeeId, lastname, firstname, title);
                result.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Optional<Employee> findMaxByYear(int year) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select e.*, sum(i.\"Total\") as \"Total\"\n" +
                    "from \"Employee\" as e\n" +
                    "         left join \"Customer\" as c on e.\"EmployeeId\" = c.\"SupportRepId\"\n" +
                    "         left join \"Invoice\" as i on c.\"CustomerId\" = i.\"CustomerId\"\n" +
                    "where extract(year from i.\"InvoiceDate\") in (?)\n" +
                    "group by e.\"EmployeeId\"\n" +
                    "order by \"Total\" desc\n" +
                    "limit 1;\n");
            ps.setInt(1, year);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String lastname = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String title = resultSet.getString(4);
                Double total = resultSet.getDouble("Total");
                Employee employee = new Employee(id, lastname, firstname, title);
                employee.setInfo(total);
                return Optional.of(employee);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
