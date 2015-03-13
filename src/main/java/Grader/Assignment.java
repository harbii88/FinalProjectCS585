package Grader;

public class Assignment {
	//annotation work with either Add or Sort function  
	@Grade(operation = "Add")
	public int add(int x , int y){
		return x-y;
	}
	// the checkcode will check the result of sort
	@Grade(operation = "Sort") 
	public int[] sort(int [] array  ){
		function(array);
           return array;
    }
	
	public int[] function(int [] array  ){
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
        }        return array;
    }
public static void  main(String[] args) throws Exception {
	// the student should include their name, their student number
	// and their class that include annotation Grade
	String studentName= "Wahed";
	String studentNumber = "1050";
	new checkCode(Assignment.class, studentName, studentNumber);

}

}
