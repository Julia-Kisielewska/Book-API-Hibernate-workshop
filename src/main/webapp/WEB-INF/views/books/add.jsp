<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add book</title>
    <link href="<c:url value="/resources/theme1/css/add.css" />" rel="stylesheet">
</head>
<body class="book-form">

<div>
    <form:form method="post" modelAttribute="book">

        <form:hidden path="id"/>


        <label>Isbn</label>
        <form:input path="isbn" type="text"/>
        <label>Tytuł</label>
        <form:input path="title" type="text"/>
        <label> Autor</label>
        <form:input path="author" type="text"/>
        <label>Wydawca</label>
        <form:input path="publisher" type="text"/>
        <label>Kategoria</label>
        <form:input path="type" type="text"/>

        <input type="submit" value="OK">
    </form:form>

</div>

</body>
</html>
