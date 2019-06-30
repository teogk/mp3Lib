

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MP3 Library</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            #insert {
                background-color: forestgreen;
                border: none;
                color: white;
                padding: 10px 15px;
                font-size: 25px;
                border-radius: 4px;

            }
            #insert:hover{
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
    <body>
        <h2>MP3 Library</h2>
        <form:form method="POST" modelAttribute="song" action="${pageContext.request.contextPath}/doinsertSong" enctype="multipart/form-data">

            <div class="my-5 text-center"><input type="file" name="mp3" class=""></div>

            <div class="my-5 text-center"> <input type="submit" value="Upload mp3" id="insert"></div>



        </form:form>

    </body>
</html>
