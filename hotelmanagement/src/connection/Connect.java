package connection;
import java.sql.*;
public class Connect {
	public static Connection createConnection(){
	 Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "0000");
//			System.out.println("Connection created");
		} catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
