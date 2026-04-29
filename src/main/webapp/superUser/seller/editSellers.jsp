<%@ page import="java.util.List" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP" %>
<%@ page import="org.example.dto.SellerDTO" %>
<%@ page import="org.example.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

    table {
        width: 50%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    {
        display: grid
    ;
        grid-template-columns: 120px 300px
    ;
        gap: 15px
    ;
        align-items: center
    ;
    }
</style>
<html>
<head>
    <br><a href="<%=ACCOUNT_JSP%>">Вернуться в личный кабинет</a></br>
    <title>Редактировать продавцов</title>
    <h1>Редактировать продавцов</h1>

</head>
<body>
<form action="addSellerPage" method="post">
    <input type="submit" value="Добавить продавца">
</form>
<table>
    <thead>
    <tr>
        <th>Номер продавца</th>
        <th>Название продавца</th>
        <th>Адрес</th>
        <th>Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<SellerDTO> sellers = (List<SellerDTO>) request.getAttribute("sellerList");
        if (sellers != null && !sellers.isEmpty()) {
            for (SellerDTO seller : sellers) {

    %>
    <tr>
        <td><%= seller.getId() %>
        </td>
        <td><%= seller.getSellerName() %>
        </td>
        <td>
                <%= seller.getSellerAddress() %>
        <td>
            <form method="post">
                <input type="submit" value="Редактировать" formaction="editSeller">
                <input type="submit" value="Удалить" formaction="removeSeller">
                <input type="hidden" name="sellerId" value="<%=seller.getId()%>">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2" style="text-align: center;">База продавцов пуста".</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
