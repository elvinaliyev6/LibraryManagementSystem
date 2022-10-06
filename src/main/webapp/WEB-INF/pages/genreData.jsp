<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
  $(function () {
    $('#genreTableId').DataTable();
  });
</script>

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