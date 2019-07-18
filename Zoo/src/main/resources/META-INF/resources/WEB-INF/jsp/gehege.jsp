<%@ page import="java.util.List" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.model.Compound" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.database.Database" %>
<%@ page import="de.stl.saar.internetentw1.myzoo.model.Animal" %>

<%! private String gehege; %>
<%! private List<Animal> animals; %>

<%@ page pageEncoding="ISO-8859-1" %>

<html>
    <head>
        <% gehege = request.getParameter("gehege"); %>
        <h1> Sie sind hier: </h1>
        <h2>
            <%
            out.print(gehege);
            %> - Gehege
        </h2>
    </head>
    <body>
        <% animals = Database.findCompoundByName(gehege).getAnimals(); %>
        <h3>
            Sie sehen diese Tiere:<br />
            <%
                for(Animal a: animals) {
                    if (a.isHidden()) continue;
                    out.println(a.getAnimalName());
                    out.println("<br />");
                }
            %>
        </h3>
        <h3>
            Diese Tiere verstecken sich:<br />
            <%
                for(Animal a: animals) {
                    if (!a.isHidden()) continue;
                    out.println(a.getAnimalName());
                    out.println("<br />");
                }
            %>
        </h3>

        <h1>
            <input type="button" onclick="window.location='/'" value="Zurück zur Karte" />
        </h1>
    </body>
</html>
