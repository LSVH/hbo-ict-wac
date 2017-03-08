<%! String title = "Login"; %><%! int level = 0; %><%@ include file="header.jsp" %>
<nav>
    <span>Login</span>
    <a href="posts.jsp">Posts</a>
    <a href="register.jsp">Register</a>
</nav>
<h1>Login to gain access to the system</h1>
<form action="doLogin" method="post">
    <table>
        <tr>
            <th>
                <label for="user">Username</label>
            </th>
            <td>
                <small>${requestScope.errorUser}</small>
                <input type="text" name="user" id="user" required>
            </td>
        </tr>
        <tr>
            <th>
                <label for="pass">Password</label>
            </th>
            <td>
                <small>${requestScope.errorPass}</small>
                <input type="password" name="pass" id="pass" required>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" name="login" value="true">Login</button>
            </td>
        </tr>
    </table>
</form>
<%@ include file="footer.jsp" %>