<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $('#authorTableId').DataTable();
    });
</script>

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
