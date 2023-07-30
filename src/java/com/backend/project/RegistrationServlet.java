
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
import java.sql.SQLException;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

      
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String rollno = request.getParameter("rollno");
        String password = request.getParameter("password");
        
       
    
     try {
         
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/form" ;
            String username = "root";
            String dbPassword = "root";
            Connection conn = DriverManager.getConnection(url, username, dbPassword);

            String sql = "INSERT INTO students (name, email, mobile, rollno, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, mobile);
            pstmt.setString(4, rollno);
            pstmt.setString(5, password);
       pstmt.executeUpdate();
       int rowsInserted = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            if (rowsInserted > 0) {
             
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
               
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            log("Error inserting data into the database: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
     
   

       
        response.sendRedirect("signin.jsp");
    }

}


