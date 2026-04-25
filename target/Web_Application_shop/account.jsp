<%@ page import="static org.example.util.NamesUtil.LOGOUT_USER" %>
<%@ page import="static org.example.util.NamesUtil.GET_ALL_PRODUCTS" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <style>
        /* Контейнер, который выравнивает строки в колонку */
        .form-container {
            display: flex;
            flex-direction: column;
            width: 400px; /* Немного увеличил, чтобы влез текст */
            gap: 15px;
            margin-top: 20px;
        }

        /* Каждая строка формы */
        .form-row {
            display: flex;
            justify-content: space-between; /* Текст слева, инпут справа */
            align-items: center;
        }

        input {
            width: 60%; /* Инпуты будут одинаковой ширины */
            box-sizing: border-box;
            padding: 5px;
        }

        /* Отдельный стиль для кнопки, чтобы она не растягивалась как остальные */
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
    <input type="submit" value="выйти из кабинета" formaction="<%=LOGOUT_USER%>">
    <input type="submit" value="Просмотреть каталог товаров" formaction="<%=SHOW_CATALOG%>">
    <input type="submit" value="Посмотреть профиль" formaction="<%=SHOW_USER_PROFILE%>">
    <input type="submit" value="Редактировать каталог" formaction="<%=EDIT_CATALOG%>">
    <input type="submit" value="Редактировать Категории товаров" formaction="<%=EDIT_ALL_CATEGORIES%>">
</form>

</body>
</html>
