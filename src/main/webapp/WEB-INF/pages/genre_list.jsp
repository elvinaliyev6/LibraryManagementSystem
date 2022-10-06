<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/static/import.jsp"></c:import>
    <script type="text/javascript" src="js/genre.js"></script>
</head>
<body>
<c:import url="/static/footer.jsp"></c:import>
<c:import url="/static/menu.jsp"></c:import>
<c:import url="/static/header.jsp"></c:import>
<c:import url="/static/info.jsp"></c:import>
<div class="ui-layout-center">

    <table border="1" class="display" id="genreTableId">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${genreList}" var="genre">
            <tr>
                <td>${genre.id}</td>
                <td>${genre.name}</td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div id="newGenreDialogId">

</div>

</body>
</html>
