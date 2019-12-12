package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("hello in servlet");

        String n=request.getParameter("userName");
        String p=request.getParameter("userPass");
        String e=request.getParameter("userEmail");
        String c=request.getParameter("userCountry");

        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/roopam","postgres","S@ntosh1");

            PreparedStatement ps=con.prepareStatement(
                    "insert into registeruser values(?,?,?,?)");

            ps.setString(1,n);
            ps.setString(2,p);
            ps.setString(3,e);
            ps.setString(4,c);

            int i=ps.executeUpdate();
            if(i>0)
                out.print("You are successfully registered...");


        }catch (Exception e2) {System.out.println(e2);}

        out.close();
    }




    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
