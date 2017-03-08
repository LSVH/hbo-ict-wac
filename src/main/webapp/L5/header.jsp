<%@ page import="L5.model.L5BlogService" %>
<%@ page import="L5.model.L5ServiceProvider" %>
<%@ page import="L5.model.L5User" %><%
    // Retrieve all data for the blog service
    L5BlogService service = L5ServiceProvider.getBlogService();

    /* Page levels
     * 0: Guest
     * 1: Registered users
     */

    L5User u = service.getLoggedInUser(request);

    String Title = title == null ? "Page not found" : title;

    if (u == null && level == 1) {
        // Redirect the user if the user IS NOT logged in
        response.sendRedirect("index.jsp");
        return;
    }

    if (u != null && level == 0) {
        // Redirect the user if the user IS logged in
        response.sendRedirect("account.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>WAC - L5 : <%=Title%></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>