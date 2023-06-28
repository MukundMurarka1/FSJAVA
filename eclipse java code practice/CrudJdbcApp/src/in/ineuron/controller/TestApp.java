package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.servicefactory.StudentServiceFactory;
import in.inuron.service.IStudentService;

public class TestApp {

	public static void main(String[] args) {
		
		
		IStudentService studentService  =StudentServiceFactory.getStudentService();
		
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter the name of student ..");
		String sname = scan.next();
		
		System.out.print("Enter the age of student ....");
		int sage = scan.nextInt();
		
		System.out.print("Enter the address of student ...");
		String saddress = scan.next();
		String msg = studentService.addStudent(sname, sage, saddress);
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("Record Inserted Successfully ..");
			
		}
		else {
			System.out.println("Something went worng :: ");
		}
		}

}
