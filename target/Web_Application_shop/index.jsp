<%@ page import="org.w3c.dom.stylesheets.LinkStyle" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    fieldset {
        width: fit-content; /* Рамка подстроится под ширину формы */
    }

    form button,
    form input[type="submit"] {
        width: 300px; /* Укажите нужную вам ширину в пикселях */
        height: 40px; /* Одинаковая высота для всех */
        padding: 5px;
        margin-top: 10px;
        cursor: pointer;
        box-sizing: border-box; /* Чтобы padding не раздувал кнопку */
    }

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

    /* Стилизуем форму как сетку */
    .my-form {
        display: grid;
        grid-template-columns: 120px 300px; /* 1-я колонка для текста, 2-я для полей */
        gap: 15px; /* Расстояние между строками и столбцами */
        align-items: center; /* Центрируем текст по вертикали относительно инпута */
    }

    .my-form input {
        padding: 5px;
        width: 100%; /* Заполнит свои 300px из сетки */
    }

    .my-form button {
        grid-column: 1 / span 2; /* Кнопка растянется на обе колонки */
        width: fit-content;
    }
</style>
<html>
<head>
    <title>Вход в систему</title>
    <h1>Вход или регистрация пользователя</h1>
    <form method="post">
        Логин: <p><input name="login" type="text"/></p>
        Пароль: <p><input name="password" type="password"/></p>
        <p><input type="submit" value="Войти" formaction="authorizeUser"/></p>
        <p><input type="submit" value="Регистрация нового пользователя" formaction="registerPage.jsp"/></p>
    </form>

</head>
<body>
</body>
</html>
