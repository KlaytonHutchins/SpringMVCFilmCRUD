<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Search by Keyword Results</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>
<body>
	<!-- Need to create a for loop here -->
	<h1>Film Details</h1>
	<c:choose>
		<c:when test="${! empty films}">
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
<<<<<<< HEAD
<<<<<<< HEAD
					<c:forEach items="${films.film}" var="film">
=======
				<c:forEach items="${films}" var="film">
					<c:forEach items="${film}" var="alist">
>>>>>>> 56f9c5fa2c7826a1a7433a10d4405d630de1773e
=======
					<c:forEach items="${films}" var="film">
>>>>>>> c5b857389a4577d2b076acbe70cfe7475043e241
						<tr>
							<td>${film.id}</td>
							<td>${film.title}</td>
							<td>${film.description}</td>
							<td>${film.length}</td>
							<td>${film.releaseYear}</td>
							<td>${film.rating}</td>
							<td>${film.category}</td>
							<td><c:forEach items="${film.actors}" var="alist">
							${alist.toString()}<br>
								</c:forEach></td>
						</tr>
					</c:forEach>
			</table>

		</c:when>
		<c:otherwise>
			<p>No such film found</p>
		</c:otherwise>
	</c:choose>


</body>
</html>