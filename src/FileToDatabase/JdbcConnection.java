package FileToDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	Connection connection=null;
	Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("class is loaded");
			 connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "varun");
			System.out.println("connection is loaded");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while load the connection "+e.getMessage());
			System.out.println("error while load the connection"+e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}
}
