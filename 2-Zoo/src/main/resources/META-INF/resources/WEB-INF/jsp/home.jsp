<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; UTF-8" %>

<html>
<head>
    <title>Zoo</title>
</head>
<body>
<div style="text-align: center;">
    <h1>
            <span style="text-decoration: underline;">
                Willkommen im Zoo
            </span>
    </h1>
    <h2>Welches Gehege möchten Sie besuchen?</h2>

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
</div>
</body>
</html>