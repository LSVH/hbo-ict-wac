<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! String title = "Blog Posts"; %>
<%! int level = -1; %>
<%@ include file="header.jsp" %>
<%
    request.setAttribute("posts", L6ServiceProvider.getBlogService().getPosts());
%>
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
<form method="post" action="/L6/doLogout">
    <table>
        <c:forEach var="post" items="${posts}">
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