<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form:form method="post" modelAttribute="author">
    First name: <form:input path="firstName"/><br/>
    <form:errors path="firstName"/><br/>
    Last name:  <form:input path="lastName"/><br/>
    <form:errors path="lastName"/><br/>

    <input type="submit" value="save"><br/>
    <br/><br/><br/><br/>
    <form:errors path="*"/>
</form:form>


</body>

</html>