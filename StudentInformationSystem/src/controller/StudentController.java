package controller;

import java.util.List;
import java.util.Map;

import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {
	StudentDao dao = new StudentDaoImplDatabase();

	public String addNewStudent(Student student) {
		if (student.getPhoneNo().length() != 10) {
			try {
				throw new PhoneException("Invalid phone number");
			} catch (PhoneException e) {
				return e.getMessage();
			}
		}
		String message = dao.addNewStudent(student);
		return message;
	}

	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub

	}

	public Student findStudentByRollNo(int rollNo) {
		return dao.findStudentByRollNo(rollNo);
	}

	public List<Student> viewAllStudent() {
		return dao.viewAllStudent();
	}

	public String addNewCourse(Course course) {
		return dao.addNewCourse(course);
	}

	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	public Course findCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean registration(Registration registration) {
		// TODO Auto-generated method stub
		return false;
	}

	public void registration(Student student, Course course) {
		// TODO Auto-generated method stub

	}

	public Map<Student, Course> viewAllRegistration() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String registrationDb(Registration registration) {
		String message="";
		Student student = dao.findStudentByRollNo(registration.getRollNo());
		Course course = dao.findCourseById(registration.getCourseId());
		if(student!=null){
			if(course !=null) {
				if(student.getQualification().equals(course.getEligibility())) {
					dao.registrationDb(registration);
					message = "Success";
				} else {
					message="You are not eligible";
				}
				
			} else {
				message="Course does not exist";
			}
		} else {
			message="Student does not exist";
		}
		return message;
	}

}
