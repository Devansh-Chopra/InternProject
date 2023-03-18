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




<div class="container">
        <h1 class="text-center">Interns<a href="/addIntern" style="text-decoration:none"><b>+</b></a></h1>
        <ul>
        <c:forEach var="intern" items="${internList}">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                <a href="/getIntern/${intern.getId()}">${intern.getFirstName()} ${intern.getLastName()}</a>
                <span class="badge bg-primary rounded-pill">${intern.getCollege()}</span>
         </li>
        </c:forEach>
        </ul>


        <br>
        <h1 class="text-center">Mentors<a href="/addMentor" style="text-decoration:none"><b>+</b></a></h1>
        <ul>
        <c:forEach var="mentor" items="${mentorList}">
        <li class="list-group-item d-flex justify-content-between align-items-center">
           <a href="getMentor/${mentor.getId()}">${mentor.getName()}</a>
        </li>

        </c:forEach>
        </ul>

        <br>
        <h1 class="text-center">Courses<a href="/addCourse" style="text-decoration:none"><b>+</b></a></h1>
        <ul>
        <c:forEach var="course" items="${courseList}">
        <li class="list-group-item d-flex justify-content-between align-items-center">
            ${course.getName()}
        </li>
        </c:forEach>
        </ul>

</div>
	</body>
</html>