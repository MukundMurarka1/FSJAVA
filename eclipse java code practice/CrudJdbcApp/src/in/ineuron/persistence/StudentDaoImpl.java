package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IstudentDao {
	Connection connection = null;
	PreparedStatement pstmt =  null;
	

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		
		String insertquery = "insert into studentinfo(`name`, `age`, `address`) values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(insertquery);
				
			}
			if(pstmt != null) {
				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddress);
				
				int rowaffected = pstmt.executeUpdate();
				
				if(rowaffected == 1 ) {
					return "success";
				}
				
				
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failure";
	}

	@Override
	public Student selectData(Integer sid) {
	
		return null;
	}

	@Override
	public String updateStudent(String sname, Integer sage, String saddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
