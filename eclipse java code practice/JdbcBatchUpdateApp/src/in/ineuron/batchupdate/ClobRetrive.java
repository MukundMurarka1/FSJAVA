package in.ineuron.batchupdate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import JdBCUtil.JDBCUtils;

public class ClobRetrive {
	public static void main (String[] args ) {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	Scanner scan = null;
	int id ;
	
	String selectfile = "select id,name,history from cities where id=?";
	
	try {
	connection = JDBCUtils.jdbcGetConnection();
	if(connection != null ) {
		pstmt = connection.prepareStatement(selectfile);
	}
	if(pstmt != null) {
		scan = new Scanner(System.in);
		if(scan != null) {
			System.out.println("Enter id of data which you want to fetch the history");
			
			id = scan.nextInt();
			pstmt.setInt(1, id);
			resultset = pstmt.executeQuery();
		}
	}
	
	if(resultset != null) {
		if(resultset.next()) {
		System.out.println("id\tname\thistory");
		
		int did = resultset.getInt(1);
		String sname = resultset.getString(2);
		Reader reader = resultset.getCharacterStream(3);
		
		File file  = new File("history_data.txt");
		FileWriter fw = new FileWriter(file);
		IOUtils.copy(reader, fw);
		
		fw.close();
		System.out.println(did+" \t "+sname+ " \t "+file.getAbsolutePath());
		}
		else {
			System.out.println("Record is not avilable for the given id :: ");
		}
	}
	}catch(SQLException | IOException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try{
			JDBCUtils.closeconnection(connection, pstmt, resultset);
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
}

