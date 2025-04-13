package School;

import java.util.Collection;
import java.util.Scanner;

public class Student_Project {

	public static void main(String[] args) {
		while(true) {
	System.out.println("********Student Managment System************");
	System.out.println("1)Add Student");
	System.out.println("2)View All Student");
	System.out.println("3)Search Student By Id");
	System.out.println("4)Update Student");
	System.out.println("5)Delete Student");
	System.out.println("6)Exit");
	
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter your choice: ");
	int option=sc.nextInt();
	
	switch (option) {
	case 1: {
		DaoInterface<Student, Integer> di=new StudentDao();
		Student std=new Student();
	System.out.println("Enter A Student Id: ");
	int id=sc.nextInt();
	sc.nextLine();
	std.setId(id);
	System.out.println("Enter A Student Name: ");
	String name=sc.nextLine();
	std.setName(name);
	System.out.println("Enter A Student Age: ");
	int age=sc.nextInt();
	sc.nextLine();
	std.setAge(age);
	System.out.println("Enter A Student Email: ");
	String email=sc.nextLine();
	sc.nextLine();
	std.setEmail(email);
	System.out.println("Enter A Student Course: ");
	String course=sc.nextLine();
	std.setCourse(course);
	
	di.addStudent(std);
	System.out.println("Student Added Succefully");
		
	break;
	}
	case 2:{
		DaoInterface<Student, Integer> di=new StudentDao();
		Collection<Student> listofStudent=di.viewAllStudent();
		for (Student student : listofStudent) {
			System.out.println(student);
		}
		break;	
		}
		case 3:{	
			DaoInterface<Student, Integer> di=new StudentDao();
			System.out.println("Enter A Id: ");
		    int id=sc.nextInt();
		   Student std=new Student();
		    //std.setId(id);
		   Object obj=di.retriveStudentById(id);
		   if(obj !=null) {
			   System.out.println(obj);
		   }
		   else
		   {
			   System.out.println("Enter Valid Id");
		   }
		    break;
		}
		case 4:{
			DaoInterface<Student, Integer> di=new StudentDao();
			System.out.println("Enter A Id: ");
		    int id=sc.nextInt();
		   Student std=new Student();
		    //std.setId(id);
		   Object obj=di.retriveStudentById(id);
//		   if(obj !=null) {
//			   System.out.println(obj);
//		   }
//		   else
//		   {
//			   System.out.println("Enter Valid Id");
//		   }
		   System.out.println("Enter A Student Name: ");
			String name=sc.nextLine();
			std.setName(name);
			sc.nextLine();
			System.out.println("Enter A Student Age: ");
			int age=sc.nextInt();
			sc.nextLine();
			std.setAge(age);
			System.out.println("Enter A Student Email: ");
			String email=sc.nextLine();
			sc.nextLine();
			std.setEmail(email);
			System.out.println("Enter A Student Course: ");
			String course=sc.nextLine();
			std.setCourse(course);
		   
			di.updateStudentDetails(std);
		    break;
		}
		case 5:{
			DaoInterface<Student, Integer> di =new StudentDao();
		//Student std=new Student();
		System.out.println("Enter Student Id For Delete");
		int id=sc.nextInt();
		di.deleteStudent(id);
		break;
		}
		case 6:{
			System.out.println("Thank You For Visit Again ");
			System.exit(option);
		}
	default:
		System.out.println("Enter Valid Choice***");
	}
	
		}
	}
	
}
