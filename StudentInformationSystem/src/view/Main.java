package view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;

import dao.StudentDao;
import dao.StudentDaoImplInMemory;
import model.Course;
import model.Qualification;
import model.Student;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao = new StudentDaoImplInMemory();

		// students
		Student student1 = new Student("John", LocalDate.of(2000, 12, 10), Qualification.Graduate, "9898765645",
				"john@gmail.com", "Mumbai");
		Student student2 = new Student("Mike", LocalDate.of(2000, 5, 8), Qualification.Intermediate, "9876543223",
				"mike@gmail.com", "Delhi");
		Student student3 = new Student("Kevin", LocalDate.of(2000, 7, 1), Qualification.Graduate, "9898543223",
				"kevin@gmail.com", "Pune");
		Student student4 = new Student("Brett", LocalDate.of(2000, 4, 9), Qualification.Master, "7898543223",
				"brett@gmail.com", "chennai");

		// DAO Methods
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		dao.addNewStudent(student4);

		// DAO Methods: for viewing students
		System.out.println("View all students: ");
		List<Student> students = dao.viewAllStudent();
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.getRollNo() + " " + student.getName() + " " + student.getPhoneNo());
		}

		// courses
		Course course1 = new Course("Java", 6, 4000, Qualification.Graduate);
		Course course2 = new Course("Python", 4, 5000, Qualification.Graduate);
		Course course3 = new Course("Azure", 3, 6000, Qualification.Master);
		Course course4 = new Course(".Net", 8, 7000, Qualification.Matric);

		// DAO Methods
		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);

		// DAO Methods: for viewing courses
		System.out.println("\nView all Courses: ");
		List<Course> courses = dao.viewAllCourses();
		Iterator<Course> iteratorCourse = courses.iterator();
		while (iteratorCourse.hasNext()) {
			Course course = iteratorCourse.next();
			System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getDurationInMonths()
					+ " " + course.getFee());
		}

		// registration
		System.out.println("\nEnter student roll no and course: ");
		int rollNo = scanner.nextInt();
		int courseId = scanner.nextInt();

		Student stud1 = dao.findStudentByRollNo(rollNo);
		Course c1 = dao.findCourseById(courseId);

		if (stud1 != null) {
			if (c1 != null) {
				dao.registration(stud1, c1);
				System.out.println("Registration Successful.");
			} else {
				System.out.println("Course not found");
			}
		} else {
			System.out.println("Student not found");
		}

		System.out.println("\nView all registrations");
		Map<Student, Course> registrations = dao.viewAllRegistration();
		Set<Map.Entry<Student, Course>> regs = registrations.entrySet();

		for (Map.Entry<Student, Course> r : regs) {
			Student s = r.getKey();
			Course c = r.getValue();
			System.out.println(s.getRollNo() + " " + s.getName() + " " + c.getCourseId() + " " + c.getCourseName());
		}

//		// DAO Method: for finding students
//		System.out.println("Enter Roll No: ");
//		int rollNo = scanner.nextInt();
//		Student student = dao.findStudentByRollNo(rollNo);
//		if(student != null) {
//			System.out.println(student.getRollNo()+" "+student.getName()+" "+ student.getEmail());
//		} else {
//			System.out.println("Student not found.");
//		}

		// DAO method: for updating information
//		System.out.println("Enter Roll No: ");
//		int rollNo = scanner.nextInt();
//		Student student = dao.findStudentByRollNo(rollNo);
//		if(student != null) {
//			System.out.println("Enter phone no: ");
//			String phoneNo = scanner.next();
//			student.setPhoneNo(phoneNo);
//			dao.updateStudentProfile(student);
//		} else {
//			System.out.println("Student not found");
//		}
//
//		// DAO Methods: for viewing updated students data
//		System.out.println("View all students: ");
//		students = dao.viewAllStudent();
//		iterator = students.iterator();
//		while(iterator.hasNext()) {
//			student = iterator.next();
//			System.out.println(student.getRollNo()+" "+student.getName()+" "+ student.getPhoneNo());
//		}

	}
}
