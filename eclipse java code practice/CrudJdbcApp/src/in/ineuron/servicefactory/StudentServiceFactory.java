package in.ineuron.servicefactory;

import in.inuron.service.IStudentService;
import in.inuron.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private StudentServiceFactory() {
		
	}
	
	private static IStudentService studentservice = null;
	
	public static IStudentService getStudentService() {
		if(studentservice == null) {
			studentservice = new StudentServiceImpl();
		}
		return studentservice;
	}

}
