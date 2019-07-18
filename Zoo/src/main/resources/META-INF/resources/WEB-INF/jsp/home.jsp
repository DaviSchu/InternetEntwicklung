<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page pageEncoding="ISO-8859-1" %>

<html>
<div style="text-align: center;">
    <head>
        <title>Zoo</title>
        <h1>Willkommen im Zoo</h1>
        <h2>Welches Gehege möchten Sie besuchen?</h2>
        <h3>Schauen Sie auf unsere Karte</h3>
    </head>
    <body>
    <form action="/Gehege">
        <!-- input type="hidden" name="gehege" value="Afrika" /-->
        <input type="submit" name="gehege" value="Afrika"/>
    </form>
    <form action="/Gehege">
        <input type="submit" name="gehege" value="Schlangen"/>
    </form>
    <form action="/Gehege">
        <input type="submit" name="gehege" value="Vogel"/>
    </form>
    <form action="/Gehege">
        <input type="submit" name="gehege" value="Pinguin"/>
    </form>
    </body>
</div>
</html>