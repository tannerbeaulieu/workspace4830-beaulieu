// NAME: TANNER BEAULIEU
// DATE: 09/16
// ASSIGNMENT: EX 09/09
// README: This web page is accessible here: http://ec2-18-191-229-159.us-east-2.compute.amazonaws.com:8080/webproject-ex-0916-beaulieu/MyServletDB

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServletDB")
public class MyServletDB extends HttpServlet {
   private static final long serialVersionUID = 1L;
   //static String url = "jdbc:mysql://http://ec2-18-191-229-159.us-east-2.compute.amazonaws.com/3306/myDB";
   static String url = "jdbc:mysql://ec2-18-191-229-159.us-east-2.compute.amazonaws.com:3306/myDB";
   
   
   static String user = "newmysqlremoteuser";
   static String password = "mypassword";
   static Connection connection = null;

   public MyServletDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      response.getWriter().append("Hello World!");
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}