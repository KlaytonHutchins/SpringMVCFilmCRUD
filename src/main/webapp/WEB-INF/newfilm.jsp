<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>New Film Results</title>
</head>
<body>
	<h1>Film Add Success!</h1>
	<c:choose>
		<c:when test="${! empty film}">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Description</th>
						<th scope="col">Length</th>
						<th scope="col">Year</th>
						<th scope="col">Rating</th>
						<th scope="col">Category</th>
						<th scope="col">Actors</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${film.id}</td>
						<td>${film.title}</td>
						<td>${film.description}</td>
						<td>${film.length}</td>
						<td>${film.releaseYear}</td>
						<td>${film.rating}</td>
						<%--<td>${film.category}</td>
						<td><c:forEach items="${film.actors}" var="alist">
							${alist.toString()}<br>
						</c:forEach></td>--%>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p>Unable to add film (film not found in database)</p>
		</c:otherwise>
	</c:choose>
			<a href="index.html"><button type="submit" class="btn btn btn-secondary">Return to Home</button></a>

</body>
</html>