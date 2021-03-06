<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.database.Database" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.model.Animal" %>

<%@ page contentType="text/html; UTF-8" %>

<%! private String gehege; %>
<%! private List<Animal> animals; %>

<% gehege = request.getParameter("gehege"); %>
<% animals = Database.findCompoundByName(gehege).getAnimals(); %>

<html>
<head>
    <title><%=gehege%>
    </title>
</head>
<body>
<div style="text-align: center;">
    <h1> Sie sind hier: </h1>
    <h2>
        <% out.print(gehege); %> - Gehege
    </h2>
    <h3>
        Sie sehen diese Tiere:<br/>
        <%
            for (Animal a : animals) {
                if (a.isHidden()) continue;
                out.println("<form action=\"/Gehege/Tier\">" +
                        "<input type=\"hidden\" name=\"gehege\" value=\"" + gehege + "\"/>" +
                        "<input type=\"submit\" name=\"name\"   value=\"" + a.getAnimalName() + "\"/>" +
                        "</form>");
                //out.println("<br />");
            }
        %>
    </h3>
    <h3>
        Diese Tiere verstecken sich:<br/>
        <%
            for (Animal a : animals) {
                if (!a.isHidden()) continue;
                out.println(a.getAnimalName());
                out.println("<br />");
            }
        %>
    </h3>

    <h1>
        <input type="button" onclick="window.location='/'" value="Zur�ck zur Karte"/>
    </h1>
</div>
</body>
</html>
