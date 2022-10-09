<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Search by ID Results</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>
<body>
	<div class=container>
		<h1>Film Details</h1>

		<c:choose>
			<c:when test="${! empty film}">
				<table class="table align-top">
					<thead class="table-light">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Title</th>
							<th scope="col">Description</th>
							<th scope="col">Length</th>
							<th scope="col">Year</th>
							<th scope="col">Rating</th>
							<th scope="col">Category</th>
							<th scope="col">Actors</th>
							<th></th>
							<!-- blank row for formatting -->
						</tr>
					</thead>
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
						<td>
				</table>
				<div class="container">
					Modify Film

					<form action="updateFilm.do" method="POST">
						<input type="text" class="form-control"
							placeholder="${film.title}" aria-label="Title" name="mTitle">
						<input type="text" class="form-control"
							placeholder="${film.description}" aria-label="description"
							name="mDescription"> <input type="text"
							class="form-control" placeholder="${film.length}"
							aria-label="Length" name="mLength"> <input type="text"
							class="form-control" placeholder="${film.releaseYear}"
							aria-label="releaseyear" name="mReleaseYear"> <input
							type="text" class="form-control" placeholder="${film.rating}"
							aria-label="rating" name="mRating"> <input type="text"
							class="form-control" placeholder="${film.category}"
							aria-label="category" name="mCategory">
						<c:forEach items="${film.actors}" var="alist">
							<input type="text" class="form-control"
								placeholder="${alist.toString()}" aria-label="actors">
							<!-- this will need name and value -->
						</c:forEach>
						<input name="filmId" value="${filmId}" type="hidden"><input
							type="submit" name="filmId" value="Update"
							class="btn btn-warning">

						<p class="h6">Modify or Delete your search entry</p>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<p>No such film found</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
