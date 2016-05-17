<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Studenten</title>
    <meta charset="iso-8859-1"/>
    <link rel="stylesheet" type="text/css" href="school.css">
</head>

<body>
<div id="results">
    <form action="Students" method="get">
        <button name="knop" value="studentenknop" type="submit"> Toon Studenten</button>
        <br/><br/>
    </form>
</div>
<div id="deklassen">
    <form action="Students" method="post">
        <c:if test="${students != null}">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Druk op de knop</th>
                </tr>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.studentNummer}</td>
                        <td>${student.naam}</td>
                        <td>
                            <button name="klassenVanAss" value="${student.studentNummer}"
                                    type="submit">assistent in de klassen
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <p>
            <%
                if (application.getAttribute("klassenList") != null) {
                    out.println(application.getAttribute("klassenList"));
                }
            %>
        </p>
    </form>
</div>
</body>
</html>