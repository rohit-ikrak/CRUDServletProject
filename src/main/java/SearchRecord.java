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

public class SearchRecord extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter pw=resp.getWriter();
		String id = req.getParameter("id");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from studinfo where id=?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				pw.print("ID: " + rs.getInt(1)+ " Name: " + rs.getString(2) + " Email: " + rs.getString(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
