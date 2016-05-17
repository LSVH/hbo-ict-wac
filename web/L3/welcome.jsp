<%@ page import="L4.model.User" %><%
    User u = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>WAC - L3 : Welcome</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Welcome to the system</h1>
<table>
    <tr>
        <th>Username</th>
        <td><%= u.getUser() %></td>
    </tr>
    <tr>
        <th>Full name</th>
        <td><%= u.getName() %></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><%= u.getMail() %></td>
    </tr>
</table>
</body>
</html>
