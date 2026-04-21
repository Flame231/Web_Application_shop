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
    <input type="submit" value="выйти из кабинета" formaction="logoutUser">
    <input type="submit" value="Просмотреть каталог товаров" formaction="showAllProducts">
    <input type="submit" value="Посмотреть профиль" formaction="showUserProfile">
</form>

</body>
</html>
