<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Artist Setlist Search</title>
</head>

<body>
<h2>Artist Setlist Search</h2>

<form:form method="get"  modelAttribute="artistSearcher" action="/artist/search">
    <table>
        <tr>
            <td><form:label path="name">Artist Name:</form:label></td>
            <td><form:input type="text" name="artistName" id="artistName" path="name"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search"/>
            </td>
        </tr>
    </table>
</form:form>



<br/>


</body>
</html>