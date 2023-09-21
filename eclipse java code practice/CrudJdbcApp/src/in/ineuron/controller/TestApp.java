package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.inuron.service.IStudentService;

public class TestApp {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id of student which you want to update the result .. ");
		int sid = scan.nextInt();
		
		IStudentService studentservice = StudentServiceFactory.getStudentService();
		Student student = studentservice.selectData(sid);
		
		if(student!=null) {
			Student newStudent = new Student();
			System.out.println("Student id is :: "+student.getSid());
			System.out.print("Student old name is :: "+student.getSname()+ " Enter newName :: ");
			String newName = scan.next();
			if(newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
				
			}else {
				newStudent.setSname(newName);
			}
			System.out.print("Stuent oldAge is :: "+student.getSage()+ " Enter newAge :: ");
			String newAge = scan.next();
			if(newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			}else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student oldAddress is :: "+student.getSaddress()+" Enter the newAddress :: ");
			String newAddress = scan.next();
			if(newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
				
			}else {
				newStudent.setSaddress(newAddress);
			}
			
			String status = studentservice.updateStudent(newStudent);
			if(status.equalsIgnoreCase("Success")) {
				System.out.println("Record updation successfully");
			}else {
				System.out.println("Record updation failed ");
			}
			
			
			
		}else {
			System.out.println("Record not found for the given student ID :: "+sid );
		}
		
		
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
