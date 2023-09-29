/*
 * 
 *	Problem Statement: agar main koi value dalta hu updatedata.html form m... 
 *	jo database m hai hi nahi... to fir mai chahta hu ki vo value naya data ban jaye...
 *	meaning m chahta hu ki jo bhi data h vo is file se InsertData m chale jae and data 
 *	add ho jae automatically yahan se.
 * 	Yeh hum kaise karenge...?
 * 
 * */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRecord extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		PrintWriter pw = resp.getWriter();
		pw.println("Id = " + id + " Name = " + name + " Email = " + email);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","");
			PreparedStatement ps = con.prepareStatement("update studinfo set name=?, email=? where id=?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, Integer.parseInt(id));
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				pw.println("Value Updated.");
			}
			else {
				pw.println("Value not Updated");
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("Value not Updated... Exception:" + e);
		}
	}
}
