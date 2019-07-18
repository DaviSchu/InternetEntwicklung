<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <h1>Willkommen im Zoo</h1>
        <h2>Welches Gehege moechten Sie besuchen?</h2>
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
            <input type="hidden" name="gehege" value="Voegel" />
            <input type="submit" value="Voegel" />
        </form>
        <form action="/Gehege">
            <input type="hidden" name="gehege" value="Pinguine" />
            <input type="submit" value="Pinguine" />
        </form>
    </body>
</html>