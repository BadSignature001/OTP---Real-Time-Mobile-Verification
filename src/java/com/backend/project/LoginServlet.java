package com.backend.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/form";
    private static final String DB_USER =  "root";
    private static final String DB_PASSWORD =  "root";
    
    static {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailOrMobile = request.getParameter("useremail");
        String password = request.getParameter("userpassword");

        if (validateLogin(emailOrMobile, password)) {
            
            response.sendRedirect("temporary.jsp");
        } else {
           
            response.sendRedirect("signin.jsp?error=1");
        }
    }
    private boolean validateLogin(String emailOrMobile, String password) {
        
        
        
        
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM students WHERE email = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, emailOrMobile);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next(); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
       

    }

}
