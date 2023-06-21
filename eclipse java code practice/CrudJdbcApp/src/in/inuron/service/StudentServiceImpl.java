package in.inuron.service;

import in.ineuron.dto.Student;
import in.ineuron.servicefactory.StudentServiceFactory;

//service layer logic 
public class StudentServiceImpl implements IStudentService {

	IStudentService stdservice ;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdservice = StudentServiceFactory.getStudentService();
		return stdservice.addStudent(sname, sage, saddress);
	}

	@Override
	public Student selectData(Integer sid) {
		// TODO Auto-generated method stub
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
