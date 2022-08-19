<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>
    <link href="<c:url value="/resources/theme1/css/add.css" />" rel="stylesheet">
</head>
<body class="book-form">

<div>
    <td> <a href="<c:url value="/admin/books/all"/>">Wstecz</a></td>
    <form:form method="post" modelAttribute="book">

        <form:hidden path="id"/>


        <label>Isbn</label>
        <form:input path="isbn" type="text"/>
        <form:errors path="isbn"
                     class="error" element="div"/>
        <label>Tytuł</label>
        <form:input path="title" type="text"/>
        <form:errors path="title"
                     class="error"/>
        <label> Autor</label>
        <form:input path="author" type="text"/>
        <form:errors path="author"
                     class="error" element="div"/>
        <label>Wydawca</label>
        <form:input path="publisher" type="text"/>
        <form:errors path="publisher"
                     class="error" element="div"/>
        <label>Kategoria</label>
        <form:input path="type" type="text"/>

        <input type="submit" value="OK">
    </form:form>

</div>

</body>
</html>
