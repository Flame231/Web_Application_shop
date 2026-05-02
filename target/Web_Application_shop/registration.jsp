<%@ page import="static org.example.util.NamesUtil.REGISTER_USER" %>
<%@ page import="static org.example.util.NamesUtil.LOGIN_JSP" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация нового пользователя</title>
    <style>

        .form-container {
            display: flex;
            flex-direction: column;
            width: 400px;
            gap: 15px;
            margin-top: 20px;
        }

        .form-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
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

<h1>Регистрация нового пользователя</h1>
<a href="<%=request.getContextPath() + LOGIN_JSP%>"> На главную</a>
<form action="<%=REGISTER_USER%>" method="post">
    <div class="form-container">

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
            <input name="newPassword" type="password"/>
        </div>
        <div>
            <label>Подтвердите пароль:</label>
            <input name="newPasswordRepeat" type="password"/>
        </div>

        <div class="form-row">
            <label>День Рождения:</label>
            <input name="birthday" type="date"/>
        </div>

        <div class="form-row">
            <label>Способ Оплаты:</label>
            <input name="paymentMethods" type="text"/>
        </div>

        <input type="submit" value="Сохранить" formaction="<%=REGISTER_USER%>"/>
    </div>
</form>

</body>
</html>
