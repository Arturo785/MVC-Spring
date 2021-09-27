package com.test.testDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //DB variables needed
        String user = "root";
        String password = "pitonpastel";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customers_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // connection
        try {
            PrintWriter out = resp.getWriter();
            out.println("Connecting to DB");

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("Successfully connected");

            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex.getCause());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
