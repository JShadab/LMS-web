<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Profile</title>

<link rel="stylesheet" href="/LMS/css/bootstrap.min.css">

<style type="text/css">
#studForm {
	width: 60%;
}
</style>

</head>
<body>

	<div class="container" align="center">
		<h1>Student Profile</h1>
	</div>

	<div class="container" id="studForm">

		<form class="form" method="post" action="/LMS/editStudent">

			<input type="hidden" name="id" value="${sessionScope.user.id}">

			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name"
					value="${sessionScope.user.name }" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email"
					value="${sessionScope.user.email}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					value="${sessionScope.user.password}" name="password">
			</div>


			<div class="form-group">
				<label for="course">Course</label> <select name="course"
					class="form-control" id="userType">

					<c:choose>
						<c:when test="${sessionScope.user.course eq 'Graduate' }">
							<option value="Graduate" selected="selected">Graduate</option>
						</c:when>
						<c:otherwise>
							<option value="Graduate">Graduate</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${sessionScope.user.course eq 'PostGraduate' }">
							<option value="PostGraduate" selected="selected">PostGraduate</option>
						</c:when>
						<c:otherwise>
							<option value="PostGraduate">PostGraduate</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${sessionScope.user.course eq 'PHD' }">
							<option value="PHD" selected="selected">PHD</option>
						</c:when>
						<c:otherwise>
							<option value="PHD">PHD</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>

			<input type="submit" value="Update" class="btn btn-primary">


		</form>

	</div>

</body>
</html>