<%! String title = "Blog Posts"; %>
<%! int level = 1; %>
<%@ include file="header.jsp" %>
<h1>Welcome to the system</h1>
<form method="post" action="doLogout">
    <table>

        <tr>
            <td></td>
            <td>
                <a href="account.jsp">My account</a>
                <button type="submit" name="logout" value="true">Logout</button>
            </td>
        </tr>
    </table>
</form>
<%@ include file="footer.jsp" %>