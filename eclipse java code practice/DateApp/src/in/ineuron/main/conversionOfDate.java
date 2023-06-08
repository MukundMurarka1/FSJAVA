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
	
		
	}

}
