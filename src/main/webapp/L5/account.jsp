<%! String title = "Account"; %>
<%! int level = 1; %>
<%@ include file="header.jsp" %>
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
            <td>
                <button type="submit" name="logout" value="true">Logout</button>
            </td>
        </tr>
    </table>
</form>
<%@ include file="footer.jsp" %>