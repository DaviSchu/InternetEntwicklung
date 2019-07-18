<html>
    <head>
    <h1> Sie sind hier:
        <%
        out.print(request.getParameter("gehege"));
        %>
    </h1>
    <h1>
        <input type="button" onclick="window.location='/'" value="Zurueck zur Karte" />
    </h1>
    </head>
    <body>
        <h2>Sie sehen diese Tiere:</h2>
        <h2>Diese Tiere verstecken sich:</h2>
    </body>
</html>
