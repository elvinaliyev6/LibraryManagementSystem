<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/static/import.jsp"></c:import>
    <script type="text/javascript" src="js/book.js"></script>
</head>
<body>
<c:import url="/static/footer.jsp"></c:import>
<c:import url="/static/menu.jsp"></c:import>
<c:import url="/static/header.jsp"></c:import>
<c:import url="/static/info.jsp"></c:import>
<div class="ui-layout-center">

    <table border="1" class="display" id="bookTableId">
        <thead>
        <tr>
            <th>#</th>
            <th>Book Name</th>
            <th>Author Fullname</th>
            <th>Book Genre</th>
            <th>Price</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookList}" var="bl">
            <tr>
                <td>${bl.id}</td>
                <td>${bl.bookGenre.book.name}</td>
                <td>${bl.author.name} ${bl.author.surname}</td>
                <td>${bl.bookGenre.genre.name}</td>
                <td>${bl.bookGenre.book.price}</td>
                <td>${bl.bookGenre.book.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
