<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</head>

	<body>
<div class="container text-center">
        <h1>${intern.getFirstName()} ${intern.getLastName()}</h1>
        <b>COLLEGE: </b> ${intern.getCollege()}<br>
        <b>MENTOR: </b> ${intern.getMentor()}<br><br>

        <h4>COURSES ASSIGNED: </h4>

        <c:forEach var="course" items="${intern.getAssignedCourses()}">
            <li class="list-group-item d-flex justify-content-between align-items-center">
            ${course.getName()}
            </li>
        </c:forEach>


<button type="button" class="btn btn-danger"><a href="/deleteIntern/${intern.getId()}" style="text-decoration:none;color:white">DELETE</a></button>
<button type="button" class="btn btn-secondary"><a href="/updateIntern/${intern.getId()}" style="text-decoration:none;color:white">EDIT</a></button>

</div>

	</body>
</html>