package in.ineuron.main;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowsetupdateapp {

	public static void main(String[] args) throws Exception {
		
		
		Scanner scan = new Scanner(System.in);
		RowSetFactory rfs = RowSetProvider.newFactory();
		JdbcRowSet jrs = rfs.createJdbcRowSet();
		
		jrs.setUrl("jdbc:mysql:///student");
		jrs.setUsername("root");
		jrs.setPassword("root123");
		
		jrs.setCommand("select id, name, age, address, salary from employees");
		jrs.execute();
		
		
			System.out.print("enter the id of employee which you want to increse the salary...");
			int id = scan.nextInt();
			
			System.out.print("enter the new salary...");
			int newsalary= scan.nextInt();
			jrs.absolute(id);
			
			System.out.print("data updated successfully ");
			
			jrs.updateInt(5, newsalary);
			jrs.updateRow();
		
		
		

	}

}
