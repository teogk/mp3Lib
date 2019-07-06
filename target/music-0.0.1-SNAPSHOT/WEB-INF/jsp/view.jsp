
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>🎵 MP3 Library</title>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="static/view.css">
    </head>

    <body>
        <h2>MP3 Library</h2>
        <table class ="col-7 p-4 text-center table-center my-5 table-sm">
            <tr>
                <th>Title</th>
                <th>Album</th>
                <th>Artist</th>
                <th>Filename</th>
                <th>Download</td>
                <th>Lyrics</td>
                <th>YouTube</td>
            </tr>
            <c:forEach items="${songs}" var="i">
                <tr>
                    <td><c:out value = "${i.title}"/></td>
                    <td><c:out value = "${i.album}"/></td>
                    <td><c:out value = "${i.artist}"/></td>
                    <td><c:out value = "${i.filename}"/></td>
                    <td><a href="download/${i.id}" download="${i.filename}"><img src="static/images/mp3.png" alt="Download" id="mp3"></a></td>
                    <td><a href="https://api.lyrics.ovh/v1/${i.artist}/${i.title}/"><img src="static/images/lyrics.png" alt="Lyrics" id="lyrics"</a></td>
                    <td><a href="https://www.youtube.com/results?search_query=${i.artist}+${i.title}"><img src="static/images/youtube.png" alt="YouTube" id="yt"></a></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <div><a href="${pageContext.request.contextPath}/insert" class="insert">Insert MP3</a></div>
    </body>
</html>