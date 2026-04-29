<%@ page import="static org.example.util.NamesUtil.LOGOUT_USER" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <style>
        .form-container {
            display: flex;
            flex-direction: column;
            width: 400px;
            gap: 15px;
            margin-top: 20px;
        }

        {
            display: flex
        ;
            justify-content: space-between
        ;
            align-items: center
        ;
        }

        input {
            width: 60%;
            box-sizing: border-box;
            padding: 5px;
        }

        input[type="submit"] {
            width: auto;
            align-self: flex-start;
            padding: 8px 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h1>Интернет-магазин</h1>
<form method="post">
    <input type="submit" value="выйти из кабинета" formaction="<%=request.getContextPath() + LOGOUT_USER%>">
    <input type="submit" value="Просмотреть каталог товаров" formaction="<%=SHOW_CATALOG%>">
    <input type="submit" value="Мои заказы" formaction="showUserOrders">
    <input type="submit" value="Посмотреть профиль" formaction="<%=SHOW_USER_PROFILE%>">
    <input type="submit" value="Редактировать каталог" formaction="<%=EDIT_CATALOG%>">
    <input type="submit" value="Редактировать Категории товаров" formaction="editProductCategories">
    <input type="submit" value="Редактировать продавцов" formaction="editSellers">
</form>

</body>
</html>
