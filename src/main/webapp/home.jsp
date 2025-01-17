<!doctype html>
<%@page import="com.ty.contact.entity.Contact"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Contact App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Welcome to Contact App</h2>
		<%
		List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
		%>
		<nav class="navbar bg-primary" data-bs-theme="dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">DashBoard</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link active" aria-current="page" href="add">Add
							Contact</a> <a class="nav-link" href="logout">Logout</a>
					</div>
				</div>
			</div>
		</nav>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ContactID</th>
					<th scope="col">Name</th>
					<th scope="col">Phone</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Contact contact : contacts) {
				%>
				<tr>
					<th scope="row"><%=contact.getCid()%></th>
					<td><%=contact.getName()%></td>
					<td><%=contact.getPhone()%></td>
					<td><a href="update?cid=<%=contact.getCid()%>">Update</a></td>
					<td><a href="delete?cid=<%=contact.getCid()%>">Delete</a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>