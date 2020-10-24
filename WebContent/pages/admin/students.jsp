<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">
<title>Admin | Students</title>



<!-- Bootstrap core CSS -->
<link href="/LMS/css/bootstrap.min.css" rel="stylesheet">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="/LMS/css/navbar-top-fixed.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/pages/admin/nav.jsp" />
	<br>
	<br>
	<br>
	<br>
	<main role="main" class="container">

		<h1 align="center">List of Registered Students</h1>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>S.No.</th>
						<th>Name</th>
						<th>Course</th>
						<th>Email</th>


					</tr>

				</thead>
				<tbody>
					<c:forEach var="student" items="${students }" varStatus="i">
						<tr>
							<td>${i.count }</td>
							<td>${student.name }</td>
							<td>${student.course}</td>
							<td>${student.email }</td>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>


</body>
</html>