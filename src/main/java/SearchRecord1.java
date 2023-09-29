

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchRecord1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("id");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","");
			PreparedStatement ps = con.prepareStatement("select * from studinfo where id=?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			pw.println("<table border=5 style=\"background-color:pink; margin-left:auto; margin-right:auto; text-align:center; border:10px solid red;\">");
			pw.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
