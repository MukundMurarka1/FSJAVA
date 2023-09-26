package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.inuron.service.IStudentService;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bufferreader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.println("Enter an option what type of operation you want to do :: [1/2/3/4/5] :: ");
			String option = bufferreader.readLine();
			
			switch(option) {
			case "1" :
				insertionOperation();
				break;
				
			case "2" :
				selectOperation() ;
				break;
				
			case "3" :
				updateRecord();
				break;
				
			case "4" :
				deletRecord();
				break;
				
			case "5" :
				System.out.println("Thanks for using this application :: ");
				System.exit(0);
				
				
			default :
				System.out.println("you have entered a wrong option please enter an option from 1 to 5  :: ");
				
			}
				
		}
	}
		

		public static void updateRecord() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the student id to be updated:: ");
		String sid = br.readLine();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.selectData(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.print("Student oldName is :: " + student.getSname() + "  Enter newName :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}
			System.out.print("Student oldAge is :: " + student.getSage() + "  Enter newAge :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student oldAddress is :: " + student.getSaddress() + "  Enter newAddress :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}

			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
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


//code does not work 

//Scanner scan = new Scanner(System.in);
//System.out.println("Enter the id of student which you want to update the result .. ");
//Integer sid = scan.nextInt();
//
//IStudentService studentservice = StudentServiceFactory.getStudentService();
//Student student = studentservice.selectData(sid);
//
//if(student!=null) {
//	Student newStudent = new Student();
//	System.out.println("Student id is :: "+student.getSid());
//	System.out.print("Student old name is :: "+student.getSname()+ " Enter newName :: ");
//	String newName = scan.next();
//	if(newName.equals("") || newName == "") {
//		newStudent.setSname(student.getSname());
//		
//	}else {
//		newStudent.setSname(newName);
//	}
//	System.out.print("Stuent oldAge is :: "+student.getSage()+ " Enter newAge :: ");
//	String newAge = scan.next();
//	if(newAge.equals("") || newAge == "") {
//		newStudent.setSage(student.getSage());
//	}else {
//		newStudent.setSage(Integer.parseInt(newAge));
//	}
//	System.out.print("Student oldAddress is :: "+student.getSaddress()+" Enter the newAddress :: ");
//	String newAddress = scan.next();
//	if(newAddress.equals("") || newAddress == "") {
//		newStudent.setSaddress(student.getSaddress());
//		
//	}else {
//		newStudent.setSaddress(newAddress);
//	}
//	
//	String status = studentservice.updateStudent(newStudent);
//	if(status.equalsIgnoreCase("Success")) {
//		System.out.println("Record updation successfully");
//	}else {
//		System.out.println("Record updation failed ");
//	}
//	
//	
//	
//}else {
//	System.out.println("Record not found for the given student ID :: "+sid );
//}
//
//
//}

