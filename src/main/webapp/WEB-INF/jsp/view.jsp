<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {border-collapse: collapse;}
        </style>
    </head>
    <body>
        <table border="solid black 1px;">

            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Album</th>
                <th>Artist</th>
                <th>Filename</th>
                <th>Download</td>
            </tr>
            <c:forEach items="${songs}" var="i">
                <tr>
                    <td><c:out value = "${i.id}"/></td>
                    <td><c:out value = "${i.title}"/></td>
                    <td><c:out value = "${i.album}"/></td>
                    <td><c:out value = "${i.artist}"/></td>
                    <td><c:out value = "${i.filename}"/></td>
                    <td><a href="download/${i.id}" download="${i.filename}">Download</a></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <div><a href="music/insert">Insert mp3</a></div>

    </body>
</html>