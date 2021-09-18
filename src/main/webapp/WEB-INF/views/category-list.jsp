<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
<br>
<a href="/addCategory">Add Category</a>
<br>
<c:forEach items="${categories}" var="cat">
    <br>
    ${category.id}
    ${category.name}
    <br>
    <a href="/deleteCategory/${category.id}">Delete Category</a>
    <a href="/updateCategory/${category.id}">Edit Category</a>
    <br>

</c:forEach>
<br>

</form>





<br>

</body>
</html>