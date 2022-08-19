<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
    <link href="<c:url value="/resources/theme1/css/books.css" />" rel="stylesheet">
</head>
<body>

<table border="1" class="styled-table">

<%--    <label>Czy na pewno chcesz usunąć książkę:</label>--%>

    <thead>
    <th>Nr</th>
    <th>Isbn</th>
    <th>Tytuł</th>
    <th>Autor</th>
    <th>Wydawca</th>
    <th>Gatunek</th>
    <th>Edytuj</th>
    <th>Usuń</th>
    </thead>
    <tbody>
        <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.type}</td>
            <td><a href="<c:url value="/admin/books/edit?id=${book.id}"/>">Edytuj</a></td>
            <td><a href="<c:url value="/admin/books/delete?id=${book.id}"/>">Usuń</a></td>
        </tr>
    </tbody>
</table>

<%--<form:form method="post" modelAttribute="book">--%>
<%--    <input type="submit" value="OK">--%>
<%--</form:form>--%>
<a href="<c:url value="/admin/books/all"/>">Wstecz</a>

</body>
</html>



