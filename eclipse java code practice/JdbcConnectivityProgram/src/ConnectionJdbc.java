import java.sql.*;
public class ConnectionJdbc {
	public static void main(String []args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/student";
		String root = "root";
		String pass ="Mukund@1996";
		String query = "select * from studentdetails";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,root,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println("First_name\tLast_name\troll_no\taddress\tmobile_no" );
		while(rs.next()) {
		String firstname = rs.getString(1);
		String lastname = rs.getString(2);
		String rollno = rs.getString(3);
		String address = rs.getString(4);
		String mobile = rs.getString(5);
		
		System.out.println(firstname+ "\t "+ lastname+"\t "+rollno+"\t "+ address+"\t "+ mobile);
		}
		rs.close();
		st.close();
		con.close();
	}

}
