

<html>
<head> 
    <title>Getting Started: Serving Web Content</title> 
    
   
</head>
<body>

<center>
	
		<h2><font size="7">Student Grading</h2>

	
	<table style="width:100%">
	<table border="10">
	  <tr>
	    <th><center><p><font size="5">Student Name</center></th>
	    <th><center><p><font size="5">Student Number</center></th> 
	    <th><center><p><font size="5">Result correction</center></th>
	    <th><center><p><font size="5">Expected result</center></th> 
	    <th><center><p><font size="5">Student result</center></th>
	  </tr>
	<#list student as l>
	
	  <tr>
	    <td><center>${l.getStudentName()}</center></td>
	    <td><center>${l.getStudentNumber()}</center></td> 
	    <td><center>${l.getCodeCorrection()}</center></td>
	    <td><center>${l.getExpectedResult()}</center></td> 
	    <td><center>${l.getResult()}</td>
	  </tr>	   
	</#list>
	</table>
</center>
</body>
</html>