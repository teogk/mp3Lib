
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
        <style>
            body{
                font-size: 18px;
            }
            table{
                border-collapse: collapse;
                background-color:white;
                border-radius: 10px;
                overflow: hidden; 

            }
            table, td, th {
                border: 1px solid black;
                padding: 1px;
                margin-left: auto;
                margin-right: auto;
            }
            tr:nth-child(1) {
                background: lightsteelblue;
            }
            tr:hover {
                background-color: lightgray;
            }
            div{text-align: center}
            .insert {
                background-color: forestgreen;
                border: none;
                color: white;
                padding: 10px 15px;
                font-size: 25px;
                border-radius: 4px;

            }
            .insert:hover{
                background-color: forestgreen;
                cursor: pointer;
                padding: 14px 20px;
                transition: 0.2s;
                box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.27), 0 17px 50px 0 rgba(0, 0, 0, 0.22);
                text-decoration: none;
                color: white;
                font-size: 28px;
            }
            h2{text-align: center;font-family:Snell Roundhand, cursive;}
        </style>
    </head>

    <body background="<c:url value='/static/images/p.png' />">

        <h2>MP3 Library</h2>
        <table class ="col-7 p-4 text-center table-center my-5 table-sm">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Album</th>
                <th>Artist</th>
                <th>Filename</th>
                <th>Download</td>
                <th>Lyrics</td>
            </tr>
            <c:forEach items="${songs}" var="i">
                <tr>
                    <td><c:out value = "${i.id}"/></td>
                    <td><c:out value = "${i.title}"/></td>
                    <td><c:out value = "${i.album}"/></td>
                    <td><c:out value = "${i.artist}"/></td>
                    <td><c:out value = "${i.filename}"/></td>
                    <td><a href="download/${i.id}" download="${i.filename}">Download</a></td>
                    <td><a href="https://api.lyrics.ovh/v1/${i.artist}/${i.title}/">Lyrics</a></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <div><a href="${pageContext.request.contextPath}/insert" class="insert">Insert MP3</a></div>
    </body>
</html>