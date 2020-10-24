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
		<h1>Add Book Form</h1>
	</div>

	<div class="container" id="regForm">

		<form class="form" method="post" action="/LMS/book">

			<input type="hidden" name="action" value="add" />

			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" placeholder="Enter Title"
					name="title">
			</div>

			<div class="form-group">
				<label for="author">Author</label> <input type="text"
					class="form-control" id="author" name="author" placeholder="Enter Author">
			</div>

			<div class="form-group">
				<label for="subject">Subject</label> <input type="text"
					class="form-control" id="subject" placeholder="Enter Subject"
					name="subject">
			</div>


			<div class="form-group">
				<label for="units">Units</label> <input type="number"
					class="form-control" id="units"
					placeholder="Enter number of copies" name="units">
			</div>

			<input type="submit" value="Add" class="btn btn-primary">


		</form>

	</div>

</body>
</html>