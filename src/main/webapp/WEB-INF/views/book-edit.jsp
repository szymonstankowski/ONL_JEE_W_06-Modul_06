<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<body>
Edycja ksiazki
<form:form method="post" modelAttribute="book" action="/books/edit/${book.id}">
    title <form:input path="title"/><br/>
    rating <form:input path="rating"/><br/>
    description <form:input path="description"/><br/>

    <form:select path="authors" items="${authors}" itemLabel="name" itemValue="id"/><br/>

    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/><br/>

    <input type="submit" value="Update">
</form:form>


</body>

</html>