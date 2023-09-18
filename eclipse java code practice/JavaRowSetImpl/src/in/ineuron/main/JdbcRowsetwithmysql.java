package in.ineuron.main;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowsetwithmysql {
	
	public static void main(String []args) throws Exception  {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		
		jrs.setUrl("jdbc:mysql:///student");
		jrs.setUsername("root");
		jrs.setPassword("root123");
		
		jrs.setCommand("select id, name, age, address, salary from employees");
		jrs.execute();
		
		System.out.println("Retriving data in the forward direction ....");
		System.out.println("ID\tName\tAge\tAddress\tsalary");
		while(jrs.next()) {
			
			System.out.println(jrs.getInt(1)+" \t "+jrs.getString(2)+" \t "+ jrs.getInt(3)+ " \t "+ jrs.getString(4)+" \t "+jrs.getInt(5));
			
		}
		
		System.out.println();
		System.out.println("Retriving data in the backward direction ....");
		System.out.println("ID\tName\tAge\tAddress\tsalary");
		while(jrs.previous()) {
			
			System.out.println(jrs.getInt(1)+" \t "+jrs.getString(2)+" \t "+ jrs.getInt(3)+ " \t "+ jrs.getString(4)+" \t "+jrs.getInt(5));
			
		}
	}

}
