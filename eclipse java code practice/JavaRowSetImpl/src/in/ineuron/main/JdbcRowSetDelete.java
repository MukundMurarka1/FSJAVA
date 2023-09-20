package in.ineuron.main;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetDelete {

	public static void main(String[] args) throws Exception {
		
		
		Scanner scan = new Scanner(System.in);
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		
		jrs.setUrl("jdbc:mysql:///student");
		jrs.setUsername("root");
		jrs.setPassword("root123");
		
		jrs.setCommand("select id, name, age, salary from employees");
		jrs.execute();
		
		System.out.print("Enter the id of employee which you want to delete .. ");
		int id = scan.nextInt();
		
		jrs.absolute(id);
		jrs.deleteRow();
		System.out.println("Record deleted successfully ....");
		
	}

}
