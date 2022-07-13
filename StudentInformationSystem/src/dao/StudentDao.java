package dao;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;

public interface StudentDao {
	// students
	String addNewStudent(Student student);

	void updateStudentProfile(Student student);

	Student findStudentByRollNo(int rollNo);

	List<Student> viewAllStudent();

	// courses
	String addNewCourse(Course course);

	List<Course> viewAllCourses();

	Course findCourseById(int courseId);

	// registration
	boolean registration(Registration registration);

	void registration(Student student, Course course);

	Map<Student, Course> viewAllRegistration();
	
	public String registrationDb(Registration registration);
}
