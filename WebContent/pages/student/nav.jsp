<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand"
		href="https://getbootstrap.com/docs/4.5/examples/navbar-fixed/#">LMS</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="/LMS/pages/student/books.jsp">Books <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="/LMS/pages/student/profile.jsp">My Profile </a></li>
				
				<li class="nav-item active"><a class="nav-link"
				href="/LMS/pages/student/issuedBooks.jsp">Issued Books </a></li>

		</ul>
		<form class="form-inline mt-2 mt-md-0" action="/LMS/bookSearch"
			method="get">

			<span style="color: white;">Welcome ${sessionScope.user.name }</span>
			&nbsp;<input class="form-control mr-sm-2" type="text"
				placeholder="Search" name="searchStr" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			&nbsp; <a class="btn btn-outline-danger my-2 my-sm-0"
				href="/LMS/logout">Logout</a>
		</form>
	</div>
</nav>