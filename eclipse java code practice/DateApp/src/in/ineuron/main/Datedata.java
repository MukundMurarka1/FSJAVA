package in.ineuron.main;

public class Datedata {

	public static void main(String[] args) {
		//java.util.date => this class is used to show date as well as time 
		
		java.util.Date date = new java.util.Date();
		System.out.println(" java util date and time is :: "+date);
		
		long datedata = date.getTime();
		System.out.println("time in milisecond :: " +datedata);
		
		//java.sql.Date => this is used to only time in database.
		
		java.sql.Date sqldate = new java.sql.Date(datedata);
		System.out.println("Date in java SQL :: "+sqldate);
		

	}

}
