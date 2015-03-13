package Student;


public class Student {

	String studentName;
	String studentNumber;
	String operation;
	int [] arrayResult  = null;
	int [] ExpectedArrayResult  = null;
	boolean codeCorrection;
	int result;
	int expectedResult;
	

	public String getResultAsString() {
		if (arrayResult == null) {
			return result + "";
		} else {
			String res = "";
			for(int a : arrayResult) {
				res += a + "";
			}
			return res;
		}
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int[] getArrayResult() {
		return arrayResult;
	}
	public void setArrayResult(int[] arrayResult) {
		this.arrayResult = arrayResult;
	}
	public int[] getExpectedArrayResult() {
		return ExpectedArrayResult;
	}
	public void setExpectedArrayResult(int[] expectedArrayResult) {
		ExpectedArrayResult = expectedArrayResult;
	}
	public boolean isCodeCorrection() {
		return codeCorrection;
	}
	public void setCodeCorrection(boolean codeCorrection) {
		this.codeCorrection = codeCorrection;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(int expectedResult) {
		this.expectedResult = expectedResult;
	}
	
	
}
