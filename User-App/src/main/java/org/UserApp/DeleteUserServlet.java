package org.UserApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class DeleteUserServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=(String)req.getSession().getAttribute("name");
		Connection con=null;
		PreparedStatement pst=null;
		String qry="delete from arko where id=?";
		if(name!=null)
		{
			try {
				Class.forName(UserUtility.DRIVER);
				con=DriverManager.getConnection(UserUtility.URL,UserUtility.USER,UserUtility.PASSWORD);
				pst=con.prepareStatement(qry);
				pst.setInt(1, id);
				pst.executeUpdate();
				PrintWriter writer=resp.getWriter();
				writer.write("<html><body><h1> User Account Deleted Succesfully </h1></body></html>");
				req.getSession().invalidate();
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
				dispatcher.include(req, resp);
			}catch(SQLException|ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(pst!=null) {
					try {
						pst.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
