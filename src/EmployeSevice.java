import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeSevice {
	
	PreparedStatement statement = null;

	public int  serviceMethod(List<Employe> employeList) {

		boolean status =false;
		int count =0;
		JdbcConnection con = new JdbcConnection();
		Connection connection2 = con.getConnection();
		try {
			int rowCount=0;
			statement = connection2.prepareStatement("INSERT INTO EMPLOYEDATA values(?,?,?,?,?)");
			for (Employe emp : employeList) {
			
				statement.setString(1, emp.getEmployeId());
				statement.setString(2, emp.getName());
				statement.setString(3, emp.getAddress());
				statement.setString(4, emp.getSalary());
				statement.setString(5, emp.getPhoneNumber());

				status = statement.execute();
				System.out.println("inserted successfuly    "+rowCount++);
				if(!status){
					count++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading the statement");
			e.printStackTrace();
		} finally {

			try {
				statement.close();
				connection2.close();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return count;
	}
}
