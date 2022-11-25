<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="container">

	<div class="row">

		<div class="col-md-6">
			<h1>Welcome to Add ToDO page!</h1>

			<form:form method="post" modelAttribute="todo">
				<fieldset class="mb-3">
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required" />
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>
				<fieldset class="mb-3">
					<form:label path="date">Target Date</form:label>
					<form:input type="text" id="targetDate" path="date"
						required="required" />
					<form:errors path="date" cssClass="text-warning" />
				</fieldset>

				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="done" />
				<button type="submit" class="btn btn-success">Submit</button>

			</form:form>
		</div>

	</div>


</div>

<%@ include file="common/footer.jspf"%>