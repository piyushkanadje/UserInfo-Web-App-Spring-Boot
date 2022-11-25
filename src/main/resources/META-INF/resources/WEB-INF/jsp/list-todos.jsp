<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 justify-content-center  mt-5 mx-auto">
				<h1> ${email} MY TODO LIST </h1>
				<p>Th is is my to do list</p>
				<table class="table">
					<thead>
						<tr>
							
							<th>Description</th>
							<th>Target Date</th>
							<th>Is Done?</th>
 							<th>Delete</th>
 							<th>Update</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.description}</td>
								<td>${todo.date}</td>
								<td>${todo.done}</td>
								<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger" > Delete  </a> </td>
								<td><a href="update-todo?id=${todo.id}" class="btn btn-warning" > Update  </a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			 <a href="add-todo" class="btn btn-primary">Add Todo</a>
			</div>
		</div>
<%@ include file="common/footer.jspf" %>