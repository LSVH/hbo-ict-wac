<%@ page import="L4.model.L4User" %>
<%
    ServletContext context = request.getSession().getServletContext();

    L4User u = (L4User) context.getAttribute("user");
    if ("".equals(u) || u == null) {
        response.sendRedirect("index.jsp");
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <title>WAC - L4 : Welcome</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Welcome to the system</h1>
<form method="post" action="doLogout">
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
        <tr>
            <td></td>
            <td><button type="submit" name="logout" value="true">Logout</button></td>
        </tr>
    </table>
</form>
</body>
</html>
<% } %>