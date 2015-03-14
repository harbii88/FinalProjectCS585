package utility;

import Student.Student;

import com.fasterxml.jackson.databind.ObjectMapper;





import java.io.File;
import java.io.IOException;


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
	
	
	public void updateStudent(Student student) {
		try {
			// convert the user object to JSON format
            mapper.writeValue(getStudentFile(student.getStudentNumber(), student.getOperation()), student);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
}
