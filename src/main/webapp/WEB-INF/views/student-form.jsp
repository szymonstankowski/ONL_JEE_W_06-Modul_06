<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

<form:form method="POST" modelAttribute="student">
    Name:
    <form:input path="firstName" />
    <br>
    Last name:
    <form:input path="lastName"/>
    <br>
    <label>Gender
    <form:radiobutton path="gender" value="M"/>
    <form:radiobutton path="gender" value="F"/>
    </label>
    <br>
    Country:
    <form:select path="country" items="${countries}"/>
    <br>
    Notes:
    <form:textarea path="notes" rows="3" cols="20"/>
    <br>
    Mailing list:
    <form:checkbox path="mailingList"/>
    <br>
    Programming skills:
    <form:checkboxes items="${programmingSkills}" path="programmingSkills"/>
    <br>
    Hobbies:
    <form:checkboxes items="${hobbies}" path="hobbies"/>
    <br>
    <br>
    <input type="submit" value="save">
</form:form>

</body>
</html>