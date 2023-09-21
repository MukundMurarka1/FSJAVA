package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.inuron.service.IStudentService;

public class TestApp {

	public static void main(String[] args) {
		deletRecord();
		
	}
	public static void deletRecord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id of student which you want to delete the record :: ");
		int sid = scan.nextInt();
		IStudentService studentservice = StudentServiceFactory.getStudentService();
		String msg = studentservice.deleteStudent(sid);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record deleted Successfully ::");
		}else if(msg.equalsIgnoreCase("not found ")) {
			System.out.println("Record not found for the given student id :: "+sid );
		}else {
			System.out.println("record deleteion failed some error occured ::  ");
		}
		
		scan.close();
	}
	public static void selectOperation() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id of student which you want to fwtch the details ::");
		int sid = scan.nextInt();
		
		IStudentService studentservice = StudentServiceFactory.getStudentService();
		Student std = studentservice.selectData(sid);
		if(std != null) {
			//System.out.println(std);
			System.out.println("SID\tName\tAge\tAddress");
			System.out.println(std.getSid()+"\t"+std.getSname()+"\t" +std.getSage()+"\t"+std.getSaddress());
			
		}else {
			System.out.println("Record not found for the given id :: "+sid);
		}
		
	}
		
		
		
	public static void insertionOperation() {
		
		
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
