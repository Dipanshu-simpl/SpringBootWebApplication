<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

<table class="table">
<caption>Your todos are</caption>
<thead>
<th>Description</th>
<th>Target Date</th>
<th>Is it Done?</th>
<th>Delete</th>
<th></th>
</thead>
<tbody>
<c:forEach items="${todos }"  var="todo">
<tr>
<td>${todo.desc }</td>
<td>${todo.targetDate }</td>
<td>${todo.done }</td>
<td><a type="button" class="btn btn-success"  href="/update-todo?id=${todo.id }">Update</a>
<td><a type="button" class="btn btn-warning"  href="/delete-todo?id=${todo.id }">Delete</a>
</tr>
</c:forEach>

</tbody>
</table>
<h3><a class="button"  href="/add-todo">Add Todo</a></h3>
</div>

<%@ include file="common/footer.jspf" %>