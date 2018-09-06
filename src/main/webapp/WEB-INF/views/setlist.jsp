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
        <td colspan="2"><b>Song</b></td>
    </tr>

    <c:set var="index" value="${0}"/>

    <c:set var="sets" value="${setlist.sets}"/>
    <c:forEach var="set" items="${sets}">
        <c:set var="s" value="${set.set}"/>
        <c:forEach var="x" items="${s}">
            <c:if test="${!empty x.encore}">
                <c:set var="index" value="${index + 1}"/>
                <tr>
                    <td style="text-align: right;"><c:out value="${index}"/> </td>
                    <td><b>Encore ${x.encore}</b></td>
                </tr>
            </c:if>
            <c:forEach var="song" items="${x.song}">
                <c:set var="index" value="${index + 1}"/>
                <tr>
                    <td style="text-align: right"><c:out value="${index}"/></td>
                    <td><c:out value="${song.name}"/></td>
                </tr>
            </c:forEach>
        </c:forEach>

    </c:forEach>

</table>

<br/>


</body>
</html>