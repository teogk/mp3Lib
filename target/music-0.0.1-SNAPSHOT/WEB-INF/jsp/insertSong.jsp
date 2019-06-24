

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" modelAttribute="song" action="${pageContext.request.contextPath}/doinsertSong" enctype="multipart/form-data">
            Song title:
            <form:input path="title"/>
            Album:
            <form:input path="album"/>
            Artist:
            <form:input path="artist"/>

            <input type="file" name="myfile" >


            <input type="submit">
        </form:form>

    </body>
</html>
