package in.ineuron.main;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowsetInsertApp {

	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
        
		jrs.setUrl("jdbc:mysql:///student");
		jrs.setUsername("root");
		jrs.setPassword("root123");
		
		jrs.setCommand("select id, name, age, address, salary from employees");
		jrs.execute();
		
		System.out.println("insert data into table from rowset ....");
		jrs.moveToInsertRow();
		
		while (true) {
			System.out.print("enter the name of employee  ");
			String name = scan.next();
			
			System.out.print("Enter the age of employee..");
			int age = scan.nextInt();
			
			System.out.print("Enter the salary of employee ...");
			int salary = scan.nextInt();
			
			jrs.updateString(2, name);
			jrs.updateInt(3, age);
			jrs.updateInt(4, salary);
			
			
			jrs.insertRow();
			
			System.out.println("Record inserted successfully ....");
			System.out.println("Do you want insert more records [yes/no]");
			String option =scan.next();
			if(option.contentEquals("no")) {
				break;
			}
			
		}
	}

}
