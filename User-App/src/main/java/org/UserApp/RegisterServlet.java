package org.UserApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("ph"));
		String password = req.getParameter("ps");
		
		Connection con = null;
		PreparedStatement pst = null;
		
		String qry = "Insert into arko values(?,?,?,?,?)";
		try 
		{
			Class.forName(UserUtility.DRIVER);
			con = DriverManager.getConnection(UserUtility.URL, UserUtility.USER, UserUtility.PASSWORD );
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.setString(2,name);
			pst.setInt(3, age);
			pst.setLong(4, phone);
			pst.setString(5, password);
			pst.executeUpdate();
			
			PrintWriter writer=resp.getWriter();
			writer.write("<html><body><h1> User saved successfully </h1></body></html>");
		}
		catch(ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) 
			{
				try 
				{
					con.close();
					System.out.println("connection is closed");
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pst!=null) 
			{
				try 
				{
					con.close();
					System.out.println("connection is closed");
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
			    }
			}
			if(pst!=null) 
			{
				try 
				{
					con.close();
					System.out.println("statement is closed");
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	
	}
}
