<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

	</head>

	<body>
	    <h1 class="text-center">ADD COURSE</h1>
<div class="container">
	    <form method="POST" class="row g-3">
          <div class="col-md-6">
            <label for="inputEmail4" class="form-label" name="name">Enter Course Name</label>
            <input type="text" class="form-control" id="inputEmail4" placeholder="Enter Course Name" name="name">
          </div>
          <div >
          <button type="submit" class="btn btn-primary">ADD</button>
          </div>
        </form>
</div>
	</body>
</html>