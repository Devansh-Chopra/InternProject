<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

	</head>

	<body>

	    <h1 class="text-center">ADD MENTOR</h1>
<div class="container">
	    <form method="POST" class="row g-3">
          <div class="col-md-6">
            <label for="inputEmail4" class="form-label" name="name">Enter Mentor Name</label>
            <input type="text" class="form-control" id="inputEmail4" placeholder="Enter Mentor Name" name="name">
          </div>
          <div >
          <button type="submit" class="btn btn-primary">ADD</button>
          </div>
        </form>
</div>

	</body>
</html>