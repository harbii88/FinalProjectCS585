package utility;

import controller.App;
import Student.Student;


// this class to add the student information then it will
// invoke app application

public class manager {
	
	public manager( String name, String number , String operation, boolean codeCorrection, int[] expectedArrayResult, int [] arrayResult){
		
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentNumber(number);
		student.setOperation(operation);
		student.setCodeCorrection(codeCorrection);
		student.setExpectedArrayResult(expectedArrayResult);
		student.setArrayResult(arrayResult);
		StudentManager studentManager = new StudentManager();
		studentManager.updateStudent(student);
	}
	
public manager( String name, String number , String operation, int result, int expectedResult, boolean checkResult) throws Exception{
		
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentNumber(number);
		student.setOperation(operation);
		student.setResult(result);
		student.setExpectedResult(expectedResult);
		student.setCodeCorrection(checkResult);
		StudentManager studentManager = new StudentManager();
		studentManager.updateStudent(student);
		//invoke app application to run spring boot
		App.Start();
	}

}
