<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="smh" uri="/WEB-INF/myTags.tld" %>

<html>
<head>
    <title>${artist.name} Setlists</title>
</head>

<body>
<h2>${artist.name} Setlists</h2>

<table>

    <tr>
        <td>Date</td>
        <td>Venue</td>
        <td>City</td>
        <td>State</td>
    </tr>

    <c:forEach var="setlist" items="${setlistList.setlist}">
        <tr>
            <td>
                <a href="/setlist?id=${setlist.id}">
                    <c:out value="${setlist.eventDate}"/>
                </a>
            </td>
            <td>
                <a href="/venue?id=${setlist.venue.id}">
                    <c:out value="${setlist.venue.name}"/>
                </a>
            </td>
            <td>
                <a href="/setlist?id=${setlist.id}">
                    <c:out value="${setlist.venue.city.name}"/>
                </a>
            </td>
            <td>
                <a href="/setlist?id=${setlist.id}">
                    <c:out value="${setlist.venue.city.state}"/>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>

<smh:pagination listItem="${setlistList.setlist}"/>

<br/>


</body>
</html>