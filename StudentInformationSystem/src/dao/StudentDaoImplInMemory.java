package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Course;
import model.Registration;
import model.Student;

public class StudentDaoImplInMemory implements StudentDao {

	public static List<Student> students = new ArrayList<Student>();
	public static Set<Course> courses = new HashSet<Course>();
	public static Map<Student, Course> registration = new HashMap<Student, Course>();

	@Override
	public String addNewStudent(Student student) {
		students.add(student);
		return null;
	}

	@Override
	public void updateStudentProfile(Student student) {
		Student student1 = findStudentByRollNo(student.getRollNo());
		int index = students.indexOf(student1);
		students.set(index, student);
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		return students.stream().filter(st -> st.getRollNo() == rollNo).findFirst().orElse(null);
	}

	@Override
	public List<Student> viewAllStudent() {
		// return students.stream().collect(Collectors.toList());
		return students;
	}

	@Override
	public String addNewCourse(Course course) {
		courses.add(course);
		return null;	// added string as a return type
	}

	@Override
	public List<Course> viewAllCourses() {
		return courses.stream().collect(Collectors.toList());
	}
	
	@Override
	public Course findCourseById(int courseId) {
		return courses.stream().filter(c->c.getCourseId()==courseId).findAny().orElse(null);
	}
	

	@Override
	public boolean registration(Registration registration) {
		return false;
	}

	@Override
	public void registration(Student student, Course course) {
		registration.put(student, course);
	}

	@Override
	public Map<Student, Course> viewAllRegistration() {
		return registration;
	}
	
	// new method
	public String registrationDb(Registration registration) {
		return null;
	}
}
