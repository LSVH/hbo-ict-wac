<%
    ServletContext context = request.getSession().getServletContext();

    if (context.getAttribute("user") != null) {
        response.sendRedirect("account.jsp");
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <title>WAC - L4 : Login</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Login to gain access to the system</h1>
<form action="doLogin" method="post">
    <table>
        <tr>
            <th>
                <label for="user">Username</label>
            </th>
            <td>
                <%
                    Object errorUser = request.getAttribute("errorUser");
                    if (errorUser != null) {
                        out.print("<small>"+errorUser+"</small>");
                    }
                %>
                <input type="text" name="user" id="user" required>
            </td>
        </tr>
        <tr>
            <th>
                <label for="pass">Password</label>
            </th>
            <td>
                <%
                    Object errorPass = request.getAttribute("errorPass");
                    if (errorPass != null) {
                        out.print("<small>"+errorPass+"</small>");
                    }
                %>
                <input type="password" name="pass" id="pass" required>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="register.jsp">Register</a>
                <button type="submit" name="login" value="true">Login</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<% } %>