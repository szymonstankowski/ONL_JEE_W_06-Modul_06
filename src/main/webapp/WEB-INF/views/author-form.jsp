<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<form:form method="post" modelAttribute="author">
    First name: <form:input path="firstName"/><br/>
    Last name:  <form:input path="lastName"/><br/>

    <input type="submit" value="save">
</form:form>


</body>

</html>