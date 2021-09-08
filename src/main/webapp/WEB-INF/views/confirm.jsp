<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<body>
Potwierdz wybor:
<form:form method="post" modelAttribute="book" action="books/delete/${book.id}">
<a href="/books/editBooks/">Cofnij</a> <br/>
<a href="/books/delete/${book.id}">Delete</a> <br/>
</form:form>


</body>
</html>