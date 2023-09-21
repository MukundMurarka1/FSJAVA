package in.inuron.service;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IstudentDao;
import in.ineuron.servicefactory.StudentServiceFactory;

//service layer logic 
public class StudentServiceImpl implements IStudentService {

	IStudentService stdservice ;
	IstudentDao stddao ;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stddao = StudentDaoFactory.getStudentDao();
		return stddao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student selectData(Integer sid) {
		stddao = StudentDaoFactory.getStudentDao();
		// TODO Auto-generated method stub
		return stddao.selectData(sid);
	}

	@Override
	public String updateStudent(Student student) {
		stddao = StudentDaoFactory.getStudentDao();
		return stddao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stddao = StudentDaoFactory.getStudentDao();
		return stddao.deleteStudent(sid);
	}

}
