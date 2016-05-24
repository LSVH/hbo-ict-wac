<%! String title = "Blog Posts"; %>
<%! int level = -1; %>
<%@ include file="header.jsp" %>
<nav>
    <span>Posts</span>
    <% if (u != null) { %>
        <a href="account.jsp">Account</a>
    <% } else { %>
        <a href="index.jsp">Login</a>
        <a href="register.jsp">Register</a>
    <% } %>
</nav>
<h1>Check out all our blog posts!</h1>
<form method="post" action="doLogout">
    <table>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="post" items="${L6ServiceProvider.getBlogService().getPosts()}">
            <tr>
                <th>${post.subject}</th>
                <td>
                    <small>${post.creationTime}</small>
                    <p>${post.text}</p>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<%@ include file="footer.jsp" %>