package in.ineuron.controller;
import java.io.*;
import java.util.*;

public class PropertiesApp {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\JdbcPropertiesApp\\applicaton.properties");
		Properties pos = new Properties();
		pos.load(fis);
		
		String url= pos.getProperty("url");
		String user = pos.getProperty("user");
		String password = pos.getProperty("password");
		
		System.out.println("url is :: "+url);
		System.out.println("user name is :: "+user);
		System.out.println("passwprd is :: "+password);
		
		

	}
}
