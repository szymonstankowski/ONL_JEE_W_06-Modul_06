<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>

<a href="/addAuthor/">Add new Author</a>
<br>
<a href="/authors/">Authors list</a>
<br>

<c:forEach items="${authors}" var="author">
    ${author.id}
    ${author.firstName}
    ${author.lastName}

    <a href="/editAuthor/${author.id}">Edit</a> <br/>
    <a href="/deleteAuthor/${author.id}">Delete</a> <br/>

</c:forEach>

</body>
</html>