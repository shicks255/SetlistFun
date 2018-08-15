<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Setlist ${setlist.info}</title>
</head>
<body>

<table>
    <tr>
        <td><b>Song</b></td>
    </tr>

    <c:set var="sets" value="${setlist.sets}"/>
    <c:forEach var="set" items="${sets}">
        <c:set var="s" value="${set.set}"/>
        <c:forEach var="x" items="${s}">
            <c:if test="${!empty x.encore}">
                <tr>
                    <td><b>Encore ${x.encore}</b></td>
                </tr>
            </c:if>
            <c:forEach var="song" items="${x.song}">
                <tr>
                    <td><c:out value="${song.name}"/></td>
                </tr>
            </c:forEach>
        </c:forEach>

    </c:forEach>

</table>

<br/>


</body>
</html>