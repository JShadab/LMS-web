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
<title>Student | Books</title>



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
	<jsp:include page="/pages/student/nav.jsp" />
	<br>
	<br>
	<br>
	<br>
	<main role="main" class="container">
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Subject</th>
						<th>Available Units</th>
						<th>ISSUE</th>

					</tr>

				</thead>
				<tbody>
					<c:forEach var="book" items="${books }">
						<tr>
							<td>${book.title }</td>
							<td>${book.author }</td>
							<td>${book.subject }</td>
							<td>${book.units }</td>
							<td><a href="/LMS/book?action=issue&id=${book.id}"
								class="btn btn-primary">Issue</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>


</body>
</html>