////import com.zaxxer.hikari.HikariConfig;
////import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


//import javax.sql.rowset.CachedRowSet;
//import javax.sql.rowset.FilteredRowSet;
//import javax.sql.rowset.JdbcRowSet;
//import javax.sql.rowset.JoinRowSet;
//import javax.sql.rowset.RowSetFactory;
//import javax.sql.rowset.RowSetProvider;
//import javax.sql.rowset.WebRowSet;
////



//import javax.sql.rowset.JdbcRowSet;
//import javax.sql.rowset.RowSetFactory;
//import javax.sql.rowset.RowSetProvider;
//





public class Hikariconnection {

	public static void main(String[] args) throws Exception {
//		RowSetFactory rsf = RowSetProvider.newFactory();
//		JdbcRowSet jrs = rsf.createJdbcRowSet();
//		CachedRowSet crs = rsf.createCachedRowSet();
//		WebRowSet wrs = rsf.createWebRowSet();
//		JoinRowSet jnrs = rsf.createJoinRowSet();
//		FilteredRowSet frs = rsf.createFilteredRowSet();
//		
//		System.out.println(jrs.getClass().getName());
//		System.out.println(crs.getClass().getName());
//		System.out.println(wrs.getClass().getName());
//		System.out.println(jnrs.getClass().getName());
//		System.out.println(frs.getClass().getName());
//
		
		String query = "select * from studentdetails";
		String configFile = "src\\db.properties";
		HikariConfig config = new HikariConfig(configFile);

		try (HikariDataSource dataSource = new HikariDataSource(config)) {
			
			// Getting the connection object from conenction pool
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select first_name,last_name,roll_no,address,mobile_no from studentdetails");
			System.out.println("first_name\tlast_name\troll_no\taddress\tmobile_no");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
						+ "\t" + resultSet.getString(4) + "/t" + resultSet.getString(5));
			}
		}
		
		
//		RowSetFactory rsf = RowSetProvider.newFactory();
//		JdbcRowSet jrs = rsf.createJdbcRowSet();// same as resultSet(connected),but it is scrollable and updatable.
//
//		// setting url,username,password
//		jrs.setUrl("jdbc:mysql:///student");
//		jrs.setUsername("root");
//		jrs.setPassword("Mukund@1996");
//
//		// setting a command for execution
//		jrs.setCommand("select first_name,last_name,roll_no,address,mobile_no from studentdetails");
//		jrs.execute();
//
//		System.out.println("Retreiveing the records in forward direction...");
//		System.out.println("first_name\tlast_name\troll_no\taddress\tmobile_no");
//		while (jrs.next()) {
//			System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4) + "\t"+ jrs.getString(5));
//		}
//		System.out.println();
//
//		System.out.println("Retreiveing the records in backward direction...");
//		System.out.println("first_name\tlast_name\troll_no\taddress\tmobile_no");
//		while (jrs.previous()) {
//			System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4) + "\t"+ jrs.getString(5));
//		}
//
//		System.out.println();
//
//		// accessing the record randomly
//		jrs.absolute(4);
//		System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4) + "\t"+ jrs.getString(5));
//
//		jrs.relative(-2);
//		System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getInt(3) + "\t" + jrs.getString(4) + "\t"+ jrs.getString(5));
//		// TODO Auto-generated method stub

	}

}





