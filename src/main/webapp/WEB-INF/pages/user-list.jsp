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
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>

<!-- Bootstrap Validator -->
<link
	href="<c:url value="/resources/bootstrapValidator/css/bootstrapValidator.css" />"
	rel="stylesheet">
<script
	src="<c:url value="/resources/bootstrapValidator/js/bootstrapValidator.js" />"></script>

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
			<%-- 			<form:select path=""> --%>
			<%-- 				<form:options itemLabel="5" /> --%>
			<%-- 				<form:options itemLabel="10" /> --%>
			<%-- 				<form:options itemLabel="15" /> --%>
			<%-- 			</form:select> --%>
			<table id="table_user" class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Username</th>
						<th>Password</th>
						<th>First name</th>
						<th>Last name</th>
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
							<td><a
								href="edit-user/?page=${currentPage}&userId=${listUser.userId}">Edit</a>
								<a
								href="delete-user?page=${currentPage }&userId=${listUser.userId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav>
			<ul class="pagination">
				<c:choose>
					<c:when test="${currentPage != 1}">
						<li><a href="users-management?page=${currentPage - 1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a href="" aria-label="Next"><span
								aria-hidden="true">&laquo;</span>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="1" end="${pageSize}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<li class="active"><a href="">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="users-management?page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${currentPage lt pageSize}">
						<li><a href="users-management?page=${currentPage + 1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a href="" aria-label="Next"><span
								aria-hidden="true">&raquo;</span>
					</c:otherwise>
				</c:choose>
			</ul>
			</nav>
		</div>
		<div id="row">
			<form:form id="form-user" class="form-horizontal" action="save-user"
				method="post" modelAttribute="user">
				<form:hidden path="userId" />
				<div class="form-group">
					<label class="col-lg-3 control-label">Username</label>
					<div class="col-lg-5">
						<form:input class="form-control" placeholder="User name"
							path="userName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Password</label>
					<div class="col-lg-5">
						<form:password class="form-control" placeholder="Password"
							path="pwd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">First name</label>
					<div class="col-lg-5">
						<form:input class="form-control" placeholder="First name"
							path="firstName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Last name</label>
					<div class="col-lg-5">
						<form:input class="form-control" placeholder="Last name"
							path="lastName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Email</label>
					<div class="col-lg-5">
						<form:input class="form-control" placeholder="Email" path="email" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-9 col-lg-offset-3">
						<form:button class="btn btn-default" value="Save" name="Save">Save</form:button>
						<input class="btn btn-default" type="reset" value="Reset" />
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#form-user')
									.bootstrapValidator(
											{
												message : 'This value is not valid',
												feedbackIcons : {
													valid : 'glyphicon glyphicon-ok',
													invalid : 'glyphicon glyphicon-remove',
													validating : 'glyphicon glyphicon-refresh'
												},
												fields : {
													userName : {
														message : 'The user name is not valid',
														validators : {
															notEmpty : {
																message : 'The user name is required and can\'t be empty'
															},
															stringLength : {
																min : 4,
																max : 10,
																message : 'The user name must be more than 4 and less than 10 characters long'
															},
															regexp : {
																regexp : /^[a-zA-Z0-9_\.]+$/,
																message : 'The user name can only consist of alphabetical, number, dot and underscore'
															}
														}
													},
													pwd : {
														validators : {
															notEmpty : {
																message : 'The password is required and can\'t be empty'
															},
															stringLength : {
																min : 6,
																max : 30,
																message : 'The password must be more than 6 and less than 30 characters long'
															},
														}
													},
													firstName : {
														message : 'The first name is not valid',
														validators : {
															notEmpty : {
																message : 'The first name is required and can\'t be empty'
															}
														}
													},
													lastName : {
														message : 'The last name is not valid',
														validators : {
															notEmpty : {
																message : 'The last name is required and can\'t be empty'
															}
														}
													},
													email : {
														validators : {
															notEmpty : {
																message : 'The email address is required and can\'t be empty'
															},
															emailAddress : {
																message : 'The input is not a valid email address'
															}
														}
													}
												}
											});
						});
	</script>
</body>
</html>