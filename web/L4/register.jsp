<%
    ServletContext context = request.getSession().getServletContext();

    if (context.getAttribute("user") != null) {
        response.sendRedirect("welcome.jsp");
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <title>WAC - L4 : Register</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Create an account to access the system</h1>
<form action="doRegister" method="post">
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
                <input type="password" name="pass" id="pass" placeholder="Password" required><br>
                <input type="password" name="pass2" id="pass2" placeholder="Confirm password" required>
            </td>
        </tr>
        <tr>
            <th>
                <label for="name">Full name</label>
            </th>
            <td>
                <%
                    Object errorName = request.getAttribute("errorName");
                    if (errorName != null) {
                        out.print("<small>"+errorName+"</small>");
                    }
                %>
                <input type="text" name="name" id="name" required>
            </td>
        </tr>
        <tr>
            <th>
                <label for="mail">E-mail</label>
            </th>
            <td>
                <%
                    Object errorMail = request.getAttribute("errorMail");
                    if (errorMail != null) {
                        out.print("<small>"+errorMail+"</small>");
                    }
                %>
                <input type="email" name="mail" id="mail" required>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="index.jsp">Login</a>
                <button type="submit" name="register" value="true">Register</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<% } %>