package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IstudentDao {
	Connection connection = null;
	PreparedStatement pstmt =  null;
	ResultSet resultset = null;
	

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
		Student student = null;
		String selectQuery = "select id, name,age,address from studentinfo where id=?";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}
			if(pstmt != null) {
				pstmt.setInt(1, sid);
				
			}
			if(pstmt != null) {
				resultset = pstmt.executeQuery();
			}
			if(resultset != null) {
				if(resultset.next()) {
					student = new Student();
					
					student.setSid(resultset.getInt(1));
					student.setSname(resultset.getString(2));
					student.setSage(resultset.getInt(3));
					student.setSaddress(resultset.getString(4));
					
					return student;
				}
				
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		String updatequery = "update studentinfo set name=?, age=?, address=? where id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(updatequery);
				
				
			}
			if(pstmt != null) {
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
				pstmt.setInt(4, student.getSid());
				
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
	public String deleteStudent(Integer sid) {
		String deletequery = "delete from studentinfo where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(deletequery);
				
			}
			if(pstmt != null) {
				
				pstmt.setInt(1, sid);
				
				
				int rowaffected = pstmt.executeUpdate();
				
				if(rowaffected == 1 ) {
					return "success";
				}else {
					return "not found ";
				
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		
		
		return "failure";
	}		
	}


