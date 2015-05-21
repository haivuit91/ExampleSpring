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

<link href="<c:url value="/resources/css/jquery.dynatable.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.dynatable.js" />"></script>
<script src="<c:url value="/resources/js/highcharts.js" />"></script>

<script src="<c:url value="/resources/js/jquery-1.7.2.min.js" />"></script>

<script type="text/javascript">
	$(document).ready(
// 			function() {
// 				var $records = $('#json-records'), myRecords = JSON
// 						.parse($records.text());
// 				$('#user-table').dynatable({
// 					dataset : {
// 						records : myRecords
// 					}
// 				});
// 			});

	$(document).ready(function() {
		$.ajax({
			url : 'json/users-list',
			method : 'GET',
			success : function(data) {
				var myRecords = JSON.parse(data.text());
				$('#user-table').dynatable({
					dataset : {
						records : myRecords
					}
				});
				return false;
			}
		});
	});
</script>

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
					<input type="text" placeholder="Email" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" class="form-control">
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
			</form>
		</div>
	</div>
	</nav>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<a href="add-user">Add User</a>

			<table id="user-table" class="display table table-bordered">
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
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>