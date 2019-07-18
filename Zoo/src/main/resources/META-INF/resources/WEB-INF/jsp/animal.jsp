<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.model.Animal" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.database.Database" %>
<%@ page pageEncoding="ISO-8859-1" %>

<%! private String name; %>
<%! private String gehege; %>
<%! private Animal animal; %>

<% name = request.getParameter("name"); %>
<% gehege = request.getParameter("gehege"); %>
<% animal = Database.findAnimalByName(name); %>

<html>
<div style="text-align: center;">

    <head>
        <title><%=name%></title>
    </head>
    <body>
    <h2>Sie beobachten: <%=name%></h2>
    <img src=<%=animal.getImage()%> >
    <h3>Hunger:<%=animal.getHunger()%></h3>
    <h1>
        <form action="/Gehege">
            <input type="submit" value="Zurück zum <%= gehege %>-Gehege" />
            <input type="hidden" name="gehege" value=<%= gehege %> />
        </form>
        <input type="button" onclick="window.location='/'" value="Zurück zur Karte"/>
    </h1>
    </body>
</div>
</html>