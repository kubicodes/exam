<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

<div class="container">
	<h1>Dies sind deine Klausuren ${name}</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Kategorie</th>
				<th>Datum</th>
				<th>Bestanden?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${retrieveExams}" var="exam">
				<tr>
					<td>${exam.name}</td>
					<td>${exam.category}</td>
					<td><fmt:formatDate value="${exam.examDate}"
							pattern="dd.MM.yyyy" /></td>
					<td>${exam.isPassed}</td>
					<td><a type="button" class="btn btn-info"
						href="/update-exam?id=${exam.id}">Ändern</a></td>
					<td><a type="button" class="btn btn-danger"
						href="/delete-exam?id=${exam.id}">Löschen</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a type="button" class="btn btn-success" href="/add-exam">Füge
			eine Klausur hinzu</a>
	</div>
</div>

<%@ include file="common/footer.jspf" %>