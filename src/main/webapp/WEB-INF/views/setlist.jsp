<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%--<title>${setlist.name} Setlists</title>--%>
</head>

<body>
<%--<h2>${artist.name} Setlists</h2>--%>

<table>

    <tr>
        <td>Date</td>
        <td>Venue</td>
        <td>City</td>
        <td>State</td>
    </tr>

    <%--<c:forEach var="setlist" items="${setlists}">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<a href="/setlist?id=${setlist.id}">--%>
                    <%--<c:out value="${setlist.eventDate}"/>--%>
                <%--</a>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="/setlist?id=${setlist.id}">--%>
                    <%--<c:out value="${setlist.venue.name}"/>--%>
                <%--</a>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="/setlist?id=${setlist.id}">--%>
                    <%--<c:out value="${setlist.venue.city.name}"/>--%>
                <%--</a>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="/setlist?id=${setlist.id}">--%>
                    <%--<c:out value="${setlist.venue.city.state}"/>--%>
                <%--</a>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>

</table>

<br/>


</body>
</html>