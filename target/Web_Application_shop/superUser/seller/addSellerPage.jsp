<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить продавца</title>
</head>
<body>

<form action="/Web_Application_shop_war/addSeller" method="post">
    Название продавца:
    <input type="text" name="sellerName">
    Адрес продавца:
    <input type="text" name="sellerAddress">
    <input type="submit" value="Подтвердить">
</form>
</body>
</html>