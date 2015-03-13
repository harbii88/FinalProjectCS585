package utility;

import Student.Student;

import com.fasterxml.jackson.databind.ObjectMapper;




import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


/* This class to manage student information and add file
 * for each student to save information and update them to
 *  retrieve the student information at any time
 */

public class StudentManager {

	private static final ObjectMapper mapper = new ObjectMapper();
	public File getStudentFile(String StudentNumber, String Operation) {
		String fileName = StudentNumber + Operation;
    	final String BASE_DIR = System.getProperty("user.home") + "/Grades";
    	//to create file for each student 
        File file = new File(BASE_DIR +  "/" + fileName + ".json");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

	public Student getStudent(String studentNumber, String Operation) {
		Student student = null;
        try {
            File StudentFile = getStudentFile(studentNumber, Operation);
            if (StudentFile.exists()) {
            	// read the file and convert the JSON content
            	// to the Student object
                student = mapper.readValue(StudentFile, Student.class);
            } else {
                student = new Student();
                student.setStudentNumber(studentNumber);    
                updateStudent(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }        
        return student;
	}
	
	/* Update student information as a text file to retrieve the
	 * information as this format
	 * 
	 */
	public void updateStudent(Student student) {
		try {
			PrintWriter wrtStudent = new PrintWriter(getStudentFile(student.getStudentNumber(), student.getOperation()));
			//write student information to json file
            wrtStudent.print(student.getStudentName()+ "      ");
            wrtStudent.print(student.getStudentNumber()+"     ");
            wrtStudent.print(student.getOperation()+"       " + student.isCodeCorrection() + "     ");
            // to check if the checked function return array or int
            if(student.getExpectedArrayResult() == null)
            	wrtStudent.print(student.getExpectedResult()+ "      " + student.getResult());
            else{
            	wrtStudent.print("{ " );
            	for(int i = 0; i <student.getExpectedArrayResult().length; i++) {  
                    wrtStudent.print(student.getExpectedArrayResult()[i]);
                    if(i == 9)
                    	wrtStudent.print(" }     " );
                    else
                    	wrtStudent.print(" , " );
                }
            	wrtStudent.print("{ " );
            	for(int i = 0; i <student.getArrayResult().length; i++) {  
                    wrtStudent.print(student.getArrayResult()[i]);
                    if(i == 9)
                    	wrtStudent.print(" }" );
                    else
                    	wrtStudent.print(" , " );
                } 
            	
            }
           wrtStudent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
