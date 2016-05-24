<%! String title = "Register"; %>
<%! int level = 0; %>
<%@ include file="header.jsp" %>
<nav>
    <span>Register</span>
    <a href="posts.jsp">Posts</a>
    <a href="index.jsp">Login</a>
</nav>
<h1>Create an account to access the system</h1>
<form action="doRegister" method="post">
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
                <input type="password" name="pass" id="pass" placeholder="Password" required><br>
                <input type="password" name="pass2" id="pass2" placeholder="Confirm password" required>
            </td>
        </tr>
        <tr>
            <th>
                <label for="name">Full name</label>
            </th>
            <td>
                <small>${requestScope.errorName}</small>
                <input type="text" name="name" id="name" required>
            </td>
        </tr>
        <tr>
            <th>
                <label for="mail">E-mail</label>
            </th>
            <td>
                <small>${requestScope.errorMail}</small>
                <input type="email" name="mail" id="mail" required>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" name="register" value="true">Register</button>
            </td>
        </tr>
    </table>
</form>
<%@ include file="footer.jsp" %>