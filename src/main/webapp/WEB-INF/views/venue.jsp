<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sh" uri="/WEB-INF/myTags.tld"%>

<html>
<head>
    <title>Venue Setlists</title>
</head>

<body>
<h2>Search Results</h2>

<c:out value="${venue.name}"/>

<table>

    <tr>
        <td>Date</td>
        <td>Artist</td>
        <td>Songs</td>
    </tr>

    <c:forEach var="venueSetlist" items="${searchForm.setlistSearchForm.setlistList.setlist}">
        <tr>
            <td>
                <a href="/setlist?id=${venueSetlist.id}">
                    <c:out value="${venueSetlist.eventDate}"/>
                </a>
            </td>
            <td>
                <a href="/artist?mbid=${venueSetlist.artist.mbid}">
                    <c:out value="${venueSetlist.artist.name}"/>
                </a>
            </td>
            <td>
                <fmt:formatNumber value="${venueSetlist.sets.size()}"/>
            </td>
        </tr>
    </c:forEach>

</table>