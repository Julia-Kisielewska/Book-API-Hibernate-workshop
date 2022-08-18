<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
    <link href="<c:url value="/resources/theme1/css/books.css" />" rel="stylesheet">
</head>
<body>

<table border="1" class="styled-table">

    <thead>
    <th>Nr</th>
    <th>Isbn</th>
    <th>Tytuł</th>
    <th>Autor</th>
    <th>Wydawca</th>
    <th>Gatunek</th>
    <th>Pokaż</th>
    <th>Edytuj</th>
    <th>Usuń</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td> <a href="<c:url value="/book-form/add"/>">Pokaż</a></td>
            <td><a href="<c:url value="/book-form/add"/>">Edytuj</a></td>
            <td><a href="<c:url value="/book-form/add"/>">Usuń</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:url value="/book-form/add"/>">Dodaj książkę</a>
</body>
</html>



