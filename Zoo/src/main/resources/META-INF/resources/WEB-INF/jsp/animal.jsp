<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.model.Animal" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.database.Database" %>

<%@ page contentType="text/html; UTF-8" %>

<%! private String name; %>
<%! private String gehege; %>
<%! private Animal animal; %>

<% name = request.getParameter("name"); %>
<% gehege = request.getParameter("gehege"); %>
<% animal = Database.findAnimalByName(name); %>

<html>
<head>
    <title><%=name%>
    </title>
</head>
<body>
<div style="text-align: center;">
    <h2>Sie beobachten <%=name%> und <%=name%> beobachtet zurück.
    </h2>
    <img src="/images/<%=animal.getImage()%>.jpg" alt="<%=animal.getImage()%>">
    <h3>
        <%
            int hunger = animal.getHunger();
            if (hunger == 0) {
                out.print("Das Tier " + name + " hat keinen Hunger");
            } else {
                out.print("Hunger: " + hunger);%>
        <input type="button" name="feed" value="feed"
               onclick="<% animal.setHunger(animal.getHunger()-1); %> location.reload(true)" />
        <%
            }
        %>
    </h3>
    <form action="/Gehege">
        <input type="submit" value="Zurück zum <%= gehege %>-Gehege"/>
        <input type="hidden" name="gehege" value="<%=gehege%>"/>
    </form>
    <input type="button" onclick="window.location='/'" value="Zurück zur Karte"/>
</div>
</body>
</html>
