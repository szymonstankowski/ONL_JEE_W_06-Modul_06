<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
<c:forEach items="${allBooks}" var="book">
    ${book.id}
    ${book.title}
    ${book.rating}
    ${book.description}
    <a href="/books/edit/${book.id}">Edit</a> <br/>
    <a href="/books/delete/${book.id}">Delete</a> <br/>

</c:forEach>

</body>
</html>