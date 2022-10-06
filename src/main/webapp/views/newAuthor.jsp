<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 10/3/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript">
    $(function () {
        $('#dobId').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<label class="lblDesign">Name</label><input type="text" id="nameId" placeholder="Name" /> <br>
<label class="lblDesign">Surname</label><input type="text" id="surnameId" placeholder="Surname" /> <br>
<label class="lblDesign">Date of birth</label><input type="text" id="dobId" placeholder="Date of birth" /> <br>
