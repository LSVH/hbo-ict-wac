<%! String title = "Account"; %><%! int level = 1; %><%@ include file="header.jsp" %>
<nav>
    <span>Account</span>
    <a href="posts.jsp">Posts</a>
</nav>
<h1>Welcome to the system</h1>
<form method="post" action="doPost">
    <table>
        <tr>
            <th><label for="title">Title</label></th>
            <td>
                <small>${requestScope.errorTitle}</small>
                <input id="title" name="title" type="text">
            </td>
        </tr>
        <tr>
            <th><label for="message">Message</label></th>
            <td>
                <small>${requestScope.errorMessage}</small>
                <textarea id="message" name="message" placeholder="Your message to the system"></textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" name="post" value="true">Submit</button>
            </td>
        </tr>
    </table>
</form>
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