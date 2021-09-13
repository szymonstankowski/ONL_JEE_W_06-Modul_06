<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>

<c:forEach items="${articles}" var="article">
    <br>
    ${article.title}
    <br>
    ${article.content}
    <br>
    ${article.creationDate}
    <br>
</c:forEach>
<br>
Ile artykulow chcesz zobaczyc:<br>
<form action="/home/limit" method="get">
    <input type="number" name="limit">
</form>





<br>

</body>
</html>