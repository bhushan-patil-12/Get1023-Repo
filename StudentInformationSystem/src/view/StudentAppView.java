package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentAppView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentController controller = new StudentController();

		System.out.println("1. Student \n2. Admin\n3. exit");
		int userType = scanner.nextInt();

		if (userType == 1) {
			String choice = "Y";
			do {
				System.out.println(
						"1. Sign up\n2. Update phone number\n3. View all courses\n4. Register for a course\n5. Sign out");
				int option = scanner.nextInt();

				switch (option) {
				case 1:
					System.out.println("Enter Name, Date of birth(dd/mm/yyyy), Phone number, Email and Address");
					String name = scanner.next();

					String dateOfBirth = scanner.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dob = LocalDate.parse(dateOfBirth, formatter);

					String phoneNumber = scanner.next();
					String email = scanner.next();
					String address = scanner.next();

					System.out.println("1. Master 2. Graduate 3. Intermediate 4. Matric");
					int q = scanner.nextInt();
					Qualification qualification = null;
					if (q == 1)
						qualification = Qualification.Master;
					if (q == 2)
						qualification = Qualification.Graduate;
					if (q == 3)
						qualification = Qualification.Intermediate;
					if (q == 4)
						qualification = Qualification.Matric;

					Student student = new Student(name, dob, qualification, phoneNumber, email, address);

					String message = controller.addNewStudent(student);
					System.out.println(message);
					break;
					
				case 4:
					System.out.println("Enter your roll no and course you want to register for");
					int rollNo=scanner.nextInt();
					int courseId = scanner.nextInt();
					String regDateString = scanner.next();
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate regDate = LocalDate.parse(regDateString, formatter2);
					
					Registration registration= new Registration(regDate, courseId, rollNo);
					message=controller.registrationDb(registration);
					System.out.println(message);
					break;

				default:
					break;
				}

				System.out.println("\ncontinue(y/n)?");
				choice = scanner.next();
			} while (choice == "y" || choice == "Y");
		} else if (userType == 2) {
			System.out.println("1. View all users\n2. Find Student\n3. Add new course");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				List<Student> students = controller.viewAllStudent();
				Iterator<Student> iterator = students.iterator();
				while (iterator.hasNext()) {
					Student st = iterator.next();
					System.out.println(st.getRollNo() + " " + st.getName() + " " + st.getQualification());
				}
				break;

				
			case 2:
				System.out.println("Enter roll no.: ");
				int rollNo = scanner.nextInt();
				Student student = controller.findStudentByRollNo(rollNo);
				if(student!=null) {
					System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getQualification());
				} else {
					System.out.println("Roll no. not found");
				}
				break;
				
			case 3:
				System.out.println("Enter course name, duration, fee");
				String courseName = scanner.next();
				int duration = scanner.nextInt();
				double fee = scanner.nextDouble();
				
				System.out.println("1. Master 2. Graduate 3. Intermediate 4. Matric");
				int q = scanner.nextInt();
				Qualification eligibility = null;
				if (q == 1)
					eligibility = Qualification.Master;
				else if (q == 2)
					eligibility = Qualification.Graduate;
				else if (q == 3)
					eligibility = Qualification.Intermediate;
				else if (q == 4)
					eligibility = Qualification.Matric;
				
				Course course = new Course(courseName, duration, fee, eligibility);
				String message = controller.addNewCourse(course);
				System.out.println(message);
				break;
				
			default:
				break;
			}
		} else {
			System.out.println("Invalid choice.");
		}

	}
}
