package in.ineuron.controller;

import in.ineuron.servicefactory.StudentServiceFactory;
import in.inuron.service.IStudentService;

public class TestApp {

	public static void main(String[] args) {
		
		
		IStudentService studentService  =StudentServiceFactory.getStudentService();
		String msg = studentService.addStudent("sachin", 41, "MI");
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("Record Inserted Successfully ..");
			
		}
		else {
			System.out.println("Something went worng :: ");
		}
		}

}
