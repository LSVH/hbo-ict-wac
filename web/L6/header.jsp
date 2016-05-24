<%@ page import="L6.model.L6BlogService" %><%@ page import="L6.model.L6ServiceProvider" %><%@ page import="L6.model.L6User" %><%
    // Retrieve all data for the blog service
    L6BlogService service = L6ServiceProvider.getBlogService();

    /* Page levels
     * 0: Unauthenticated visitors
     * 1: Authenticated users
     * -1: All visitors
     */

    L6User u = service.getLoggedInUser(request);

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
%><!DOCTYPE html>
<html>
<head>
    <title>WAC - L6 : <%=Title%></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>