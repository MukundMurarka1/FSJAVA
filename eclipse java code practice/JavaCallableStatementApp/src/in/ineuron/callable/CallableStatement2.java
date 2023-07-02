package in.ineuron.callable;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.utils.JdbcUtility;

public class CallableStatement2 {
	
	public static void main(String args[]) {
	
	Connection connection = null;
	CallableStatement cstmt = null;
	ResultSet resultset = null;
	Scanner scan = null;
	
	String prod1 = null;
	String prod2 = null;
	boolean flag = false;
	
	String storedProcedureCall ="{call p_get_product_detail_by_name(?,?)}";
	
	try {
		connection = JdbcUtility.getJdbcConnection();
		
		if(connection != null) {
			cstmt = connection.prepareCall(storedProcedureCall);
		}
		
		scan = new Scanner(System.in);
		if(scan != null) {
			System.out.println("enter the product name ");
			prod1 = scan.next();
			
			System.out.println("Enter the product name ");
			prod2 = scan.next();
		}
		 //setting the value 
		if(cstmt != null) {
			cstmt.setString(1, prod1);
			cstmt.setString(2, prod2);
			
		}
		
		//execute the query 
		if(cstmt != null) {
			cstmt.execute();
		}
		
		//get the resultset 
		if(cstmt != null) {
			resultset = cstmt.getResultSet();
		}
		
		//process the Resultset 
		if(resultset != null) {
			System.out.println("pid\tpname\tprice\tquantity");
			
			while(resultset.next()) {
				System.out.println(resultset.getInt(1)+ "\t" +resultset.getString(2)+ "\t" +resultset.getInt(3)+ "\t"+ resultset.getInt(4));
				flag = true;
			}
			
		}
		
		
		//process the nature of resultset and displayed the value 
		if(flag == true) {
			System.out.println("Record available and displayed ....");
		}else {
			System.out.println("Record not available cannot be displayed ....");
		}
		
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
