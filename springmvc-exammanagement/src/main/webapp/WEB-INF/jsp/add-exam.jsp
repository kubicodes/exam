<%@ include file="common/header.jspf"%>
<%@ include file="common/navbar.jspf"%>

<div class="container">
	Füge eine Klausur hinzu.
	<form:form action="/add-exam" method="post" modelAttribute="exam">
		<form:hidden path="id" />
		<div class="form-group">
			<form:label path="name">Name:</form:label>
			<form:input path="name" type="text" name="name" class="form-control"
				required="required" />
		</div>
		<div class="form-group">
			<form:label path="category">Kategorie: </form:label>
			<form:input path="category" type="text" name="category"
				class="form-control" required="required" />
			<form:errors path="category" cssClass="text-warning" />
		</div>
		<div class="form-group">
			<form:label path="examDate">Datum: </form:label>
			<form:input path="examDate" type="text" name="category"
				class="form-control" required="required" />
			<form:errors path="examDate" cssClass="text-warning" />
		</div>
		<div class="form-group">
			<form:label path="isPassed">Status:</form:label>
			<form:select path="isPassed" class="form-control">
				<form:option value="true">Bestanden</form:option>
				<form:option value="false">Nicht Bestanden</form:option>
   			</form:select>
		</div>
		<button type="submit" class="btn btn-success">Hinzufügen</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>
