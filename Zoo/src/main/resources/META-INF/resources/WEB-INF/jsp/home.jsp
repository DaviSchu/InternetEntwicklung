<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <body>
        <h1>Arschgeile Seite</h1>
        <h2>Willst du wissen was 29 + 22 ist?</h2>
        <button name="hi" type="button" onclick="doit()">JA</button>
        <input type="submit" value="Afrika"
               onclick="window.location='/Gehege';"
                <% session.setAttribute("gehege", "afrika");%>
        />

        <script>
            function doit() {
                alert("ALARM   ALAAAAARM");
            }
        </script>
    </body>
</html>