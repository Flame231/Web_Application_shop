<%@ page import="static org.example.util.NamesUtil.LOGIN_JSP_RELATIVE_PATH" %>
<%@ page import="static org.example.util.NamesUtil.REGISTER_USER" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация нового пользователя</title>
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

<h1>Регистрация нового пользователя</h1>
<a href="<%=LOGIN_JSP_RELATIVE_PATH%>"> На главную</a>
<form action="<%=REGISTER_USER%>" method="post">
    <div class="form-container"> <!-- Тот самый класс из стилей -->

        <div class="form-row">
            <label>Имя:</label>
            <input name="name" type="text"/>
        </div>

        <div class="form-row">
            <label>Логин:</label>
            <input name="login" type="text"/>
        </div>

        <div class="form-row">
            <label>Пароль:</label>
            <input name="password" type="password"/> <!-- Сменил тип на password -->
        </div>

        <div class="form-row">
            <label>День Рождения:</label>
            <input name="birthday" type="date"/>
        </div>

        <div class="form-row">
            <label>Способ Оплаты:</label>
            <input name="paymentMethods" type="text"/>
        </div>

        <input type="submit" value="Сохранить" formaction ="<%=REGISTER_USER%>"/>
    </div>
</form>

</body>
</html>
