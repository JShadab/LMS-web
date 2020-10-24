<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet" href="/LMS/css/bootstrap.min.css">

<style type="text/css">
#loginForm {
	width: 40%;
}
</style>

<script type="text/javascript">
	function displayMsg() {

		var message = '${param.msg}';

		if (message) {
			alert(message);
		}

	}
</script>

</head>
<body onload="displayMsg()">

	<div class="container" align="center">
		<jsp:include page="/pages/header.jsp" /></div>



	<div class="container" id="loginForm">


		<form class="form" method="post" action="/LMS/login">

			<div class="form-group">
				<label for="userType">User Type</label> <select name="userType"
					class="form-control" id="userType">
					<option value="Admin">Admin</option>
					<option value="Student">Student</option>
				</select>
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					placeholder="Enter email" class="form-control" id="email"
					name="email">
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>


			<input type="submit" value="Login" class="btn btn-primary"> <a
				href="/LMS/pages/studRegistration.jsp" class="btn btn-success">Sign
				Up</a>

		</form>



	</div>

	<div class="container" align="center">
		<jsp:include page="/pages/footer.jsp" /></div>

</body>
</html>