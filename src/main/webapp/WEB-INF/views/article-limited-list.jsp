<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>

<c:forEach items="${limitArticles}" var="article">
    <br>
    ${article.title}
    <br>
    ${article.content}
    <br>
    ${article.creationDate}
    <br>
</c:forEach>
<br>

<a href="/home">Wroc do listy glownej</a>



<br>

</body>
</html>