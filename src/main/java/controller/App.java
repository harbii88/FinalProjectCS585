package controller;
import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;





@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {                

	/** 
	 * The following bean configures the file upload 
	 * facility used by Spring web framework.
	 */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }    

    /**
     * This is a good example of how Spring instantiates
     * objects. The instances generated from this method
     * will be used in this project, where the Autowired
     * annotation is applied.
     */
   
    /** This is the running main method for the web application */
    public static void Start() throws Exception {
    	
        System.setProperty("java.awt.headless", "false");
        // Run Spring Boot
        SpringApplication.run(App.class, System.getProperty("user.home") + "/Grades");
    }
    
}
