package org.UserApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		long phone=Long.parseLong(req.getParameter("ph"));
		String password=req.getParameter("ps");
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		String qry="select * from arko where phone=? and password=?";
			try 
			{
				Class.forName(UserUtility.DRIVER);
				con=DriverManager.getConnection(UserUtility.URL, UserUtility.USER, UserUtility.PASSWORD );
				
				pst=con.prepareStatement(qry);
				pst.setLong(1, phone);
				pst.setString(2, password);
				rs= pst.executeQuery();
				
				RequestDispatcher dispatcher =null;
				if(rs.next()) 
				{
					dispatcher = req.getRequestDispatcher("Home.jsp");
					HttpSession session = req.getSession();
					session.setAttribute("id", rs.getInt("id"));
					session.setAttribute("name", rs.getString("name"));
					session.setAttribute("age", rs.getInt("age"));
					session.setAttribute("phone", rs.getLong("phone"));
					session.setAttribute("Password", rs.getString("password"));
					dispatcher.forward(req, resp);
				}
				else 
				{
					PrintWriter writer = resp.getWriter();
					writer.write("<html><body><h1> Invalid Phone or Password </h1></body></html>");
					dispatcher =req.getRequestDispatcher("Login.jsp");
					dispatcher.include(req, resp);
				}
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
						pst.close();
						System.out.println("connection is closed");
					}
					catch(SQLException e) 
					{
						e.printStackTrace();
			
				    }
			
		        }
			}
	}
}