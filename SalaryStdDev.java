import java.sql.*;

class SalaryStdDev {
	
	public static void main(String[] args) {

		// Check number of arguments
		if(args.length!=2 && args.length!=4) {
			System.out.println("Number of arguments do no match");
			System.exit(1);
		}

		String databaseName = args[0];
		String tableName = args[1];
		
		String url = "jdbc:db2:"+databaseName;

		try {
			
			// Setup JDBC Driver
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con = null;

			// Connection to database
			if(args.length==2)
				con = DriverManager.getConnection(url);
			else {
				String login = args[2];
				String password = args[3];
				con = DriverManager.getConnection(url, login, password);
			}
			
			// Query to get salary from employee table
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SALARY FROM " + tableName);

			int length = 0;
			double sum = 0, sum_of_sq = 0;

			while(rs.next()) {
				length += 1;
				sum += rs.getDouble(1);
				sum_of_sq += Math.pow(rs.getDouble(1), 2);
			}

			// Print standard deviation
			System.out.println("Standard Deviation = " + Math.sqrt((sum_of_sq/length)-Math.pow(sum/length, 2)));

			// Close connections
			rs.close();
			stmt.close();
			con.close();

		} catch(Exception e) {
			// Print exception (if occurs)
			e.printStackTrace();
		}
	}
}