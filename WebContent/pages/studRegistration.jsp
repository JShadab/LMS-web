<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Warden Registration</title>

<link rel="stylesheet" href="/LMS/css/bootstrap.min.css">

<style type="text/css">
#regForm {
	width: 60%;
}
</style>

</head>
<body>

	<div class="container" align="center">
		<h1>Student Registration Form</h1>
	</div>

	<div class="container" id="regForm">

		<form class="form" method="post" action="/LMS/register">

			<!-- Warden Account Details -->

			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name">
			</div>

			<div class="form-group">
				<label for="phone">Email</label> <input type="email"
					class="form-control" id="email" name="email">
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>


			<div class="form-group">
				<label for="course">Course</label> <select name="course"
					class="form-control" id="userType">
					<option value="ug">Graduate</option>
					<option value="pg">Post Graduate</option>
					<option value="phd">PhD</option>
				</select>
			</div>

			<input type="submit" value="Register" class="btn btn-primary">
			<a href="/LMS/index.jsp" class="btn btn-warning">Login</a>

		</form>

	</div>

</body>
</html>