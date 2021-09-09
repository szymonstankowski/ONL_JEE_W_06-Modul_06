<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>

<a href="/addPublisher/">Add new Publisher</a>
<br>
<a href="/publishers/">Publishers list</a>

<c:forEach items="${publishers}" var="publisher">
    <br>
    ${publisher.id}
    <br>
    ${publisher.name}
    <br>
    <a href="/editPublisher/${publisher.id}">Edit</a> <br/>
    <a href="/deletePublisher/${publisher.id}">Delete</a> <br/>
</c:forEach>

</body>
</html>