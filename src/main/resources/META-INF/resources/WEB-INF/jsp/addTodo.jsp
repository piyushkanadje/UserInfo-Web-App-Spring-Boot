<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="container">

	<div class="row">

		<div class="col-md-6">
			<h1>Welcome to Add ToDO page!</h1>
			<form:form method="post" modelAttribute="todo">
				Description: <form:input type="text" path="description"
					required="required" />
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="done" />
				<button type="submit">Submit</button>
			</form:form>
		</div>

	</div>


</div>
<%@ include file="common/footer.jspf"%>