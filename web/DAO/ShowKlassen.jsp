<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Klassen</title>
    <meta charset="iso-8859-1"/>
    <link rel="stylesheet" type="text/css" href="school.css">
</head>

<body>
<div id="results">
    <form action="Klassen" method="get">
        <button name="knop" value="klassenknop" type="submit">Toon Klassen</button>
        <br/><br/>
    </form>
</div>
<div id="destudenten">
    <form action="Klassen" method="post">
        <c:if test="${klassen != null}">
            <table>
                <tr>
                    <th>KlasId</th>
                    <th>Code</th>
                    <th>Assistent</th>
                    <th>Druk op de
                        knop
                    </th>
                </tr>
                <c:forEach items="${klassen}" var="klas">
                    <tr>
                        <td>${klas.klasId}</td>
                        <td>${klas.klasCode}</td>
                        <c:if test="${klas.assistent != null}">
                            <td>${klas.assistent.naam}</td>
                        </c:if>
                        <c:if test="${klas.assistent == null}">
                            <td>Geen assistent</td>
                        </c:if>
                        <td>
                            <button name="getAllStudents" value="${klas.klasId}"
                                    type="submit">alle studenten
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <p>
            <%
                if (application.getAttribute("studentsList") != null) {
                    out.println(application.getAttribute("studentsList"));
                }
            %>
        </p>
    </form>
</div>
</body>
</html>