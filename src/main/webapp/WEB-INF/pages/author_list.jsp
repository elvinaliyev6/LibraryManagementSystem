<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/static/import.jsp"></c:import>
    <script type="text/javascript" src="js/author.js"></script>
</head>
<body>

<div class="ui-layout-center">

    <table class="display" id="authorTableId" border="1">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of birth</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${authorList}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.surname}</td>
                <td>${author.dob}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
<c:import url="/static/footer.jsp"></c:import>
<c:import url="/static/menu.jsp"></c:import>
<c:import url="/static/header.jsp"></c:import>
<c:import url="/static/info.jsp"></c:import>
<div id="newAuthorDialogId">

</div>

</body>

</html>
