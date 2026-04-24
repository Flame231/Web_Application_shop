<%@ page import="org.example.dto.UserDTO" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP_RELATIVE_PATH" %>
<%@ page import="static org.example.util.NamesUtil.REGISTER_USER" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<% UserDTO userDTO = (UserDTO) request.getAttribute("userDTO"); %>

<h1>Профиль пользователя</h1>
<a href="<%=ACCOUNT_JSP_RELATIVE_PATH%>">Вернуться в личный кабинет</a>
<form action="<%=REGISTER_USER%>" method="post">
    <p>
        Имя:
        <input type="text" name="name" value="<%= userDTO.getName()%>" required/>
        <input type="hidden" name="id" value="<%=userDTO.getId()%>">
    </p>

    <p>
        Логин:
        <input type="text" name="login" value="<%= userDTO.getLogin()%>" required/>
    </p>

    Новый пароль:
    <input type="password" name="password" value="<%= userDTO.getPassword()%>" required/>
    <p>
        День Рождения:
        <input type="date" name="birthday" value="<%= userDTO.getBirthday()%>" required/>
    </p>

    <p>
        Способ Оплаты:
        <input type="text" name="paymentMethods" value="<%= userDTO.getPaymentMethods()%>" required/>
    </p>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
