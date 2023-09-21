package in.ineuron.persistence;

import in.ineuron.dto.Student;

public interface IstudentDao {
	
	//operation to be implemented 
	
	public String addStudent(String sname, Integer sage, String saddress);
	
	public Student selectData(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid );

}
