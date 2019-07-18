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
        <h1>Sie sehen diese Tiere:</h1>
    </body>
</html>
