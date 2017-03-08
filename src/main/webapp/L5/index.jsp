<%! String title = "Login"; %>
<%! int level = 0; %>
<%@ include file="header.jsp" %>
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
<%@ include file="footer.jsp" %>