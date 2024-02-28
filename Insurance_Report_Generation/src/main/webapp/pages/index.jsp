<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
</head>
<body>

	<div class="container">
		<h3 class="pb-3 pt-3">Insurance Report Generation Application</h3>

		<div>

			<form:form action="search" modelAttribute="search" method="POST">
				<table>
					<tr>
						<td>Plan Name</td>
						<td><form:select path="planName">
								<form:option value="">-Select-</form:option>
								<form:options items="${names}" />
							</form:select></td>

						<td>Plan Status</td>
						<td><form:select path="planStatus">
								<form:option value="">-Select-</form:option>
								<form:options items="${status}" />
							</form:select></td>

						<td>Gender</td>
						<td><form:select path="gender">
								<form:option value="">-Select-</form:option>
								<form:option value='M'>Male</form:option>
								<form:option value='F'>Female</form:option>
							</form:select></td>


					</tr>

					<tr>
						<td>Start Date</td>
						<td><form:input path="startDate" type="date" /></td>
						
						
						<td>End Date</td>
						<td><form:input path="EndDate" type="date" /></td>

					</tr>

					<tr>
						<td><input type="submit" value="search"
							class="btn btn-primary" /></td>

						<td><a href="/" class="btn btn-secondary">Reset</a></td>
					</tr>

				</table>
			</form:form>

			<hr />

			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Holder Name</th>
						<th>Gender</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Benefit Amount</th>
						<th>Start Date</th>
						<th>End Date</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${plans}" var="plan">
						<tr>
							<td>${plan.citizenId}</td>
							<td>${plan.citizenName}</td>
							<td>${plan.gender}</td>
							<td>${plan.planName}</td>
							<td>${plan.planStatus}</td>
							<td>${plan.benefitAmount}</td>
							<td>${plan.planStartDate}</td>
							<td>${plan.planEndDate}</td>
						</tr>
					</c:forEach>
					<tr>
						<c:if test="${empty plans}">
							<td colspan="8" align="center">No Records found !</td>
						</c:if>
					</tr>
				</tbody>
			</table>


			<hr />
           
           <p class="text-success">${msg}</p>
			Export : <a href="excel">Excel Report</a> &nbsp; &nbsp; <a href="pdf">Pdf Report</a>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>