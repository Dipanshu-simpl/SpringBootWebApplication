<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h2><b>Add a new todo:</b></h2>
<form:form method="post"  modelAttribute="todo">
<form:hidden path="id"/>
<fieldset class="form-group">
<h4><form:label path="desc">Description</form:label></h4>
<form:input type="text"  path="desc"  class="form-control"  required="required"/>
<form:errors path="desc" cssClass="text-warning"></form:errors>
</fieldset>
<br>
<fieldset class="form-group">
<h4><form:label path="targetDate">Target Date</form:label></h4>
<form:input type="text"  path="targetDate"  class="form-control"  required="required"/>
<form:errors path="targetDate" cssClass="text-warning"></form:errors>
</fieldset>
<br>
<button type="submit"  class="btn btn-success" >Add</button>
</form:form>
<h3>Your name is ${name }</h3>
</div>
<%@ include file="common/footer.jspf" %>
