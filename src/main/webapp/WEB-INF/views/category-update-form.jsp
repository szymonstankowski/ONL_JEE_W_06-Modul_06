<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form:form method="post" modelAttribute="category">
    Category name: <form:input path="name"/><br/>


    <input type="submit" value="save">
</form:form>


</body>

</html>