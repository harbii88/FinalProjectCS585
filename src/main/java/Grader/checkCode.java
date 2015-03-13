package Grader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import utility.manager;

/* This class to send the input to any function that will be
 * checked then revcive the output, after that it will compare
 * the function output result with the correct the result
 * 
 */
public class checkCode {


    checkCode(Class<?> checkedClass, String studentName,
    		String studentNumber) throws Exception {
    	
    	Constructor<?> constructor = checkedClass.getConstructor();
    	//get all methods from the class
        Method[] methods = checkedClass.getDeclaredMethods();
        Random r = new Random();
        
        for( Method method : methods){
        	boolean Checkresult = false;
        	//check the function annotated by grade
        	if(method.isAnnotationPresent(Grade.class)){
        		Grade grade = method.getAnnotation(Grade.class);
        		String operation = grade.operation();
        		//to sort the array to compare it with student result
        		if("Sort".equals(operation)){
        			int [] array = new int[10];
			        int [] temp = new int [10];
			        for (int i = 0; i < array.length; i++) {
			            array[i] = r.nextInt()%20;
			        }
    				temp = array.clone();
    				//invoke the sort function to test it
					method.invoke(constructor.newInstance(), array);
					Sort(temp);
					//compare between correct sort and student sort
					if( Arrays.equals(array, temp))
						Checkresult = true;
					new manager(studentName, studentNumber, operation, Checkresult, temp, array );
        			
				//to check the add function
        		} else if("Add".equals(operation)){
        			int x = 25, y =20;
        			// invoke the add function to test it
        			Object result = method.invoke(constructor.newInstance(), x, y);
        			int addResult = (Integer) result;
        			int j = x + y;
        			if(addResult == j)
        				Checkresult = true;
        			System.out.print(method.getName() + "	" + Checkresult + "		Expected result		"+ j + "		the result 		" + addResult +"\n");
        			new manager(studentName, studentNumber, operation, addResult, j, Checkresult );
        			
        		}
        	}
        }
    }
    
    //to sort the array to compare it with the returned output
    public  int[] Sort(int [] array  ){
		int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                	int temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        return array;
    }
}