<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AsianTech - HaiVu</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script src="<c:url value="/resources/js/jquery-1.7.2.min.js" />"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="users-list">Spring MVC</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" placeholder="Email" class="form-control" />
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" class="form-control" />
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
			</form>
		</div>
	</div>
	</nav>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<form:select path="">
				<form:options itemLabel="5" />
				<form:options itemLabel="10" />
				<form:options itemLabel="15" />
			</form:select>
			<table id="table_user" class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>User Name</th>
						<th>Password</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listUser" items="${listUser}" varStatus="status">
						<tr>
							<td>${listUser.userId}</td>
							<td>${listUser.userName}</td>
							<td>${listUser.pwd}</td>
							<td>${listUser.firstName}</td>
							<td>${listUser.lastName}</td>
							<td>${listUser.email}</td>
							<td><a href="edit-user?userId=${listUser.userId}">Edit</a> <a
								href="delete-user?userId=${listUser.userId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav>
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
			</nav>
		</div>
		<div id="row">
			<form:form class="form-inline" action="save-user" method="post"
				modelAttribute="user">
				<form:hidden path="userId" />
				<div class="form-group">
					<form:input class="form-control" placeholder="User name"
						path="userName" />
				</div>
				<div class="form-group">
					<form:password class="form-control" placeholder="Password"
						path="pwd" />
				</div>
				<div class="form-group">
					<form:input class="form-control" placeholder="First name"
						path="firstName" />
				</div>
				<div class="form-group">
					<form:input class="form-control" placeholder="Last name"
						path="lastName" />
				</div>
				<div class="form-group">
					<form:input class="form-control" placeholder="Email" path="email" />
				</div>
				<div class="form-group">
					<form:button class="btn btn-default" value="Save" name="Save">Save</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>