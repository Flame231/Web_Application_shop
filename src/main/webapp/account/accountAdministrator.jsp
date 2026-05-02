<%@ page import="static org.example.util.NamesUtil.SHOW_CATALOG" %>
<%@ page import="static org.example.util.NamesUtil.EDIT_CATALOG" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_USER_PROFILE" %>
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
<h2>Администратор</h2>
<form method="post">
    <input type="submit" value="выйти из кабинета" formaction="<%=request.getContextPath() + LOGOUT_USER%>">
    <input type="submit" value="Редактировать каталог" formaction="<%=request.getContextPath() + EDIT_CATALOG%>">
    <input type="submit" value="Редактировать Категории товаров"
           formaction="<%=request.getContextPath() + EDIT_PRODUCT_CATEGORIES%>">
    <input type="submit" value="Редактировать продавцов" formaction="<%=request.getContextPath() + EDIT_SELLERS%>">
</form>

</body>
</html>
