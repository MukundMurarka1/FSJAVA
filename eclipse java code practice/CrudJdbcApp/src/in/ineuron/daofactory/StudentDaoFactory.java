package in.ineuron.daofactory;

import in.ineuron.persistence.IstudentDao;
import in.ineuron.persistence.StudentDaoImpl;

public class StudentDaoFactory {
	
	private StudentDaoFactory() {
		
	}
	
	private static IstudentDao studentdao = null;
	
	public static IstudentDao getStudentDao() {
		if(studentdao == null) {
			studentdao =new StudentDaoImpl();
			
		}
		return studentdao;
	}

}
