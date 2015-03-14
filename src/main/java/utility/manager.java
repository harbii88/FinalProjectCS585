package utility;

import java.util.Arrays;

import controller.App;
import Student.Student;


// this class to add the student information then it will
// invoke app application

public class manager {
	
	public manager( String name, String number , String operation, boolean codeCorrection, int[] expectedArrayResult, int [] arrayResult){
		String correction;
		if(!codeCorrection)
			correction ="False";
		else
			correction = "True";
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentNumber(number);
		student.setOperation(operation);
		student.setCodeCorrection(correction);
		student.setExpectedResult(Arrays.toString(expectedArrayResult));
		student.setResult(Arrays.toString(arrayResult));
		StudentManager studentManager = new StudentManager();
		studentManager.updateStudent(student);
	}
	
public manager( String name, String number , String operation, int result, int expectedResult, boolean codeCorrection) throws Exception{
	String correction;
	if(!codeCorrection)
		correction ="False";
	else
		correction = "True";
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentNumber(number);
		student.setOperation(operation);
		student.setExpectedResult(Integer.toString(expectedResult));
		student.setResult(Integer.toString(result));
		student.setCodeCorrection(correction);
		StudentManager studentManager = new StudentManager();
		studentManager.updateStudent(student);
		//invoke app application to run spring boot
		App.Start();
	}

}
