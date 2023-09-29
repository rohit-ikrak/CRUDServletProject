

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertRecord extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		PrintWriter pw = resp.getWriter();
		String link = "jdbc:mysql://localhost:3306/studentinfo";
		String user = "root";
		String password = "";
		String query = "insert into studinfo values(?, ?, ?)";
		pw.println("School ID: " + id + " Name: " + name + " Email: " + email);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(link, user, password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setString(3, email);
			int x = ps.executeUpdate();
			if(x>0) {
				pw.println("Value Inserted.");
			}
			else {
				pw.println("Value not Inserted.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			pw.println("Value not Inserted... Exception:" + e);
		}
		
	}
}
