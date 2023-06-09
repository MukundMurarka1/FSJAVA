package in.ineuron.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class conversionOfDate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("enter date in dd-MM-yyyy format :: " );
		String sdate =  scan.next();
		
		//conversion of string date into java.util.dateformat 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(sdate);
		
		//conversion of util date into Sql date 
		long datevalue = udate.getTime();
		java.sql.Date sqldate = new java.sql.Date(datevalue);
		
		// prinlting all the three values 
		
		System.out.println("Date in string format ::" +sdate);
		System.out.println("Date in util format ::"+udate);
		System.out.println("Date in sql format ::"+sqldate);
		
		
		System.out.println("enter the DOM in yyyy-MM-dd format :: ");
		String standardinput = scan.next();
		java.sql.Date standardsqldate = java.sql.Date.valueOf(standardinput);
		
		System.out.println("print the date in the standardiput format :: " +standardinput);
		System.out.println("Print the date in the standard sql date format :: "+standardsqldate);
	
		
	}

}
