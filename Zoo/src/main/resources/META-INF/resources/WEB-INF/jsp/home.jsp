<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>


<%@ page pageEncoding="ISO-8859-1" %>

<html>
    <head>
        <h1>Willkommen im Zoo</h1>
        <h2>Welches Gehege möchten Sie besuchen?</h2>
        <h3>Schauen Sie auf unsere Karte</h3>
    </head>
    <body>
        <form action="/Gehege">
            <input type="hidden" name="gehege" value="Afrika" />
            <input type="submit" value="Afrika" />
        </form>
        <form action="/Gehege">
            <input type="hidden" name="gehege" value="Schlangen" />
            <input type="submit" value="Schlangen" />
        </form>
        <form action="/Gehege">
            <input type="hidden" name="gehege" value="Vogel" />
            <input type="submit" value="Voegel" />
        </form>
        <form action="/Gehege">
            <input type="hidden" name="gehege" value="Pinguin" />
            <input type="submit" value="Pinguin" />
        </form>
    </body>
</html>