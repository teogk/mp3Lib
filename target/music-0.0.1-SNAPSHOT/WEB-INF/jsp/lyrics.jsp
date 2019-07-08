<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <title>🎵 MP3 Library</title>
        <script src="https://code.jquery.com/jquery-3.4.0.min.js" integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <style>
            body{
                text-align: center;
                margin-top: 5px;
            }
            h2{
                margin-top: 4px;
                margin-bottom: 30px;
                font-family:Snell Roundhand, cursive;
            }
            #lyrics{
                margin: 20px;
                font-size: 19px;
                font-family:Snell Roundhand, cursive;
                background-color: lightgrey;
                border-radius: 8px;
            }
            #title,#artist{
                background-color: lightgrey;
                border-radius: 8px;
                margin: 20px;
                padding: 12px;
                font-size: 23px;
            }

        </style>

    </head>

    <body>

        <h2>MP3 Library</h2>
        <div>
            <h4>ARTIST:</h4>
            <p id ="artist">${artist}</p>
        </div>
        <div>
            <h4>SONG:</h4>
            <p id="title" >${title}</p>
        </div>
        <h4>LYRICS:</h4>
        <div id="lyrics"></div>
        <script>
            jQuery(App);
            function App($) {

                let URL = "https://api.lyrics.ovh/v1/" + $("#artist").html() + "/" + $("#title").html();
                $.ajax({
                    url: URL,
                    success: handleResponse,
                    error: handleError
                });

                function handleResponse(data) {
                    $("#lyrics").html(data.lyrics);
                }

                function handleError(jqXHR, textStatus, errorThrown) {
                    console.log(textStatus, errorThrown);
                    $("#lyrics").html("Something went wrong");
                }
            }
        </script>  
    </body>
</html>