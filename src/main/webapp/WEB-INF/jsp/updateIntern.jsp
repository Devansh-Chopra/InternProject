<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

	</head>

	<body>


	    <h1 class="text-center">UPDATE INTERN</h1>


        <div class="container">
	    <form method="POST" class="row g-3">
          <div class="col-md-6">
            <label for="inputEmail4" class="form-label" name="firstName">First Name</label>
            <input type="text" class="form-control" id="inputEmail4" placeholder="Enter First Name" name="firstName" value="${intern.getFirstName()}">
          </div>
          <div class="col-md-6">
            <label for="inputPassword4" class="form-label">Last Name</label>
            <input type="text" class="form-control" id="inputPassword4" placeholder="Enter Last Name" name="lastName" value="${intern.getLastName()}">
          </div>
          <div class="col-12">
            <label for="inputAddress" class="form-label">College</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="Enter College Name" name="college" value="${intern.getCollege()}">
          </div>
          <div class="col-12">
            <label for="inputAddress2" class="form-label">Mentor</label>
            <select class="form-select form-select-sm" aria-label=".form-select-sm example" id="mentor" name="mentor" >
                <c:forEach var="mentor" items="${mentorList}">
                    <c:choose>
                      <c:when test="${mentor.getId()==intern.getMentor().getId()}">
                        <option selected value=${mentor.getId()}>${mentor.getName()}</option>
                      </c:when>
                      <c:otherwise>
                        <option value=${mentor.getId()}>${mentor.getName()}</option>
                      </c:otherwise>
                    </c:choose>


                </c:forEach>
            </select>
          </div>

          <div class="col-md-6">
            <label for="inputCity" class="form-label">Courses</label>
            <select class="form-select" id="course" name="assignedCourses" size="3" multiple>
                <c:forEach var="course" items="${courseList}">

                    <c:choose>
                      <c:when test="${courseSet.contains(course)}">
                        <option selected value=${course.getId()}>${course.getName()}</option>
                      </c:when>
                      <c:otherwise>
                        <option value=${course.getId()}>${course.getName()}</option>
                      </c:otherwise>
                    </c:choose>


                </c:forEach>
            </select>
          </div>
          <div >
            <button type="submit" class="btn btn-primary">ADD</button>
          </div>
        </form>


</div>








	</body>
</html>