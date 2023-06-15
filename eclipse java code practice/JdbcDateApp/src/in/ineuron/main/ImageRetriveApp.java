package in.ineuron.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class ImageRetriveApp {
	public static void main (String []args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		String selectQuery = "select sid,sname,image from information where sid=?";
		try {
			connection = JdbcUtil.jdbcgetconnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}
			if(pstmt != null) {
				Scanner scan = new Scanner(System.in);
				System.out.print("enter the id of student of which you want to see the image :: ");
				int sid = scan.nextInt();
				
				pstmt.setInt(1, sid);
				resultset = pstmt.executeQuery();
			}
			if(resultset !=null) {
				if(resultset.next()) {
					System.out.println("SID\tSNAME\tIMAGE");
					
					int sid  = resultset.getInt(1);
					String sname = resultset.getString(2);
					InputStream is = resultset.getBinaryStream(3);
					
					File file = new File("copied.jpg");
					FileOutputStream fos = new FileOutputStream(file);
					int i = is.read();
					while(i != -1) {
						fos.write(i);
						i = is.read();
					}
					fos.close();
					System.out.println(sid+ "\t" +sname+ "\t" + file.getAbsolutePath());
				}
				else {
					System.out.println("Record is not avilable for the given id :: ");
				}
				
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
			
		}catch(IOException ie ) {
			ie.printStackTrace();
		}
		finally {
			try{
				JdbcUtil.closeConnection(connection, pstmt, resultset);
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
