package controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import Student.Student;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {      

	
	
	@RequestMapping(value = "/grades/ping", method = RequestMethod.GET)
    String healthCheck() {

    	// Then, run the application locally and check your changes
    	//  run the application locally with URL: http://localhost:8080/
        return "OK";
    }
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/grades", method = RequestMethod.GET)
	
	ModelAndView  getStudentGrade() {
		ObjectMapper mapper = new ObjectMapper();
    	final String BASE_DIR = System.getProperty("user.home") + "/Grades";
    	File folder = new File(BASE_DIR);
    	File[] listOfFiles = folder.listFiles();
    	List list = new ArrayList();
    	String string = null;
    	byte[] bytes = null;
    	// read all files in grade folder
    	for (File file : listOfFiles) {
    	    if (file.isFile()) {
    	    	
    	    	
				try {
					bytes = Files.readAllBytes(file.toPath());
					string = new String(bytes ,"UTF-8");
					 list.add(string);
				} catch (IOException e) {

					e.printStackTrace();
				}
				
               
    	    }
    	}
    	//create model view to display the result locally
    	ModelAndView model = new ModelAndView("home");
    	model.addObject("lists", list);

    	return model;
 
    }
    
    

    /*********** Web UI Test Utility **********/
    /**
     * This method provide a simple web UI for you to test the different 
     * functionalities used in this web service. 
     */
    @RequestMapping(value = "/grades/home", method = RequestMethod.GET)
    ModelAndView getUserHomepage(@PathVariable("Stduent") String userId) {
    	Student student = new Student();
    	
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("student", student.getStudentName());        

        return modelAndView;
    }
    
    	
    
}