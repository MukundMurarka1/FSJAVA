package in.ineurin.util;

public class JdbcUtility {
	
	private JdbcUtility() {
		
	}
	
	static{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class loded successfully ....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
