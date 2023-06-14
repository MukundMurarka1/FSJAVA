package in.inuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	
public String addStudent(String sname, Integer sage, String saddress);
	
	public Student selectData(Integer sid);
	
	public String updateStudent(String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid );


}
