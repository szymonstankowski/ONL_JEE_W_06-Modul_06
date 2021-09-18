<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<a href="/publishers">Cofnij do listy publishers</a>
<br>
<form:form method="post" modelAttribute="publisher">
    Publisher name: <form:input path="name"/><br/>
    <form:errors path="name"/><br/>
    <input type="submit" value="save"><br/>
    <br/><br/><br/><br/>
    <form:errors path="*"/>
</form:form>


</body>

</html>