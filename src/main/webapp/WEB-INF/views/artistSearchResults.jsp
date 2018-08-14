<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Artist Setlist Search</title>
</head>

<body>
<h2>Search Results</h2>


<table>
    <tr>
        <td>Name</td>
        <td>Stuff</td>
    </tr>

    <c:forEach var="artist" items="${artistList}">
        <tr>
            <td>
                <a href="/artist?mbid=${artist.mbid}">
                    <c:out value="${artist.name}"/>
                </a>
            </td>
            <td><c:out value="${artist.disambiguation}"/> </td>
        </tr>
    </c:forEach>

</table>

<br/>


</body>
</html>