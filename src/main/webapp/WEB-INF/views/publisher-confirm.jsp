<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<body>
Potwierdz wybor:
<form:form method="post" modelAttribute="publisher" action="/deletePublisher/${publisheer.id}">
    <a href="/publishers/">Cofnij</a> <br/>
    <a href="/deletePublisher/${publisher.id}">Delete</a> <br/>
</form:form>


</body>
</html>