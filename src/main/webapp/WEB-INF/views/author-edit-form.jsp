<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<body>
Edycja autora
<form:form method="post" modelAttribute="author" action="/editAuthor/${author.id}">
    First name: <form:input path="firstName"/>
    <br>
    Last name: <form:input path="lastName"/>

    <input type="submit" value="Update">
</form:form>


</body>

</html>