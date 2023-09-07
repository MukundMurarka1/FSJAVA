package in.ineuron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPApp {

	public static void main(String[] args) throws Exception {
		
		String query = "select id, name, age, address, salary from employees";
		String configfile ="D:\\FSJAVA\\ecliplise code for practice\\HikariCPConnectionPulling\\src\\in\\ineuron\\main\\db.properties";
        HikariConfig config = new HikariConfig(configfile);
        
        try (HikariDataSource datasource = new HikariDataSource(config)){
        	
        	
        	Connection connection = datasource.getConnection();
        	Statement stmt = connection .createStatement();
        	ResultSet resultset = stmt.executeQuery(query);
        	System.out.println("ID\tName\tAge\tAddress\tsalary");
        	while(resultset.next()) {
        		
        		System.out.println(resultset.getInt(1)+" \t "+resultset.getString(2)+" \t "+ resultset.getInt(3)+ " \t "+ resultset.getString(4)+" \t "+resultset.getInt(5));
        	}
        }
	}
}
	
	


