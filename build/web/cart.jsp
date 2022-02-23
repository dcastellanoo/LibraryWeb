<%-- 
    Document   : cart
    Created on : 17-feb-2022, 13:03:51
    Author     : diego
--%>

<%@page import="model.Book"%>
<%@page import="model.ShoppingCart"%>
<%@page import="model.Catalogue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Catalogue catalogue = (Catalogue) session.getAttribute("catalogue");
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>ShoppingCart</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1><center>SHOPPING CART</center></h1> 
        <%
            if (cart.getNumBooks() != 0){ %>
                <form action="FrontController" method="GET">
                    <input type="hidden" name="command" value="ClearCartCommand">
                    <input type="submit" value="Vaciar carrito" class="boton_personalizado"> <br>
                </form>
        
                <%
                for (Book b : cart.getShoppingList().keySet()){ %> 
                    <div class="bookDisplay" padding="10px">
                    <p>
                        <br>
                    </p>
                    <img src = "<%= b.getImageURL() %>" width ="150" height = "188" align = "left">
                    <h2><b> <%= b.getTitle() %> </h2></b>
                    <b> ISBN: </b> <%= b.getIsbn() %> <br>
                    <b>Precio unitario:</b> <%= b.getPrice() %> $<br>
                    <b>Cantidad:</b> <%= cart.getShoppingList().get(b) %> <br>
                    
                    <form action="FrontController" method="GET">
                    <input type="hidden" name="command" value="IncrementBookCommand">
                    <input type="hidden" name="isbn" value= <%= b.getIsbn() %> >
                    <input type="submit" value="+" style="height:30px; width:30px"> <br>
                    </form>
                    
                    <form action="FrontController" method="GET">
                    <input type="hidden" name="command" value="DecrementBookCommand">
                    <input type="hidden" name="isbn" value= <%= b.getIsbn() %> >
                    <input type="submit" value="-" style="height:30px; width:30px">
                    </form> <br> 
                    <b>Importe:</b> <%= b.getPrice() * cart.getShoppingList().get(b) %> $ <br>
                    <p>
                        <br>
                    </p>
                    </div>
        <%       
                }
        %>
                <center><form action="index.jsp" method="GET">
                        <input type="submit" value="Seguir comprando" class="boton_personalizado" style="height:50px; width:200px">
                        </form></center>
                <center><form action="purchasesummary.jsp" method="GET">
                        <input type="submit" value="Procesar pago" class="boton_personalizado" style="height:50px; width:200px">
                        </form></center>
        <%
            } else {
        %>
                No ha añadido ningún libro <br>
                <p>
                    <br>
                </p>
                <form action="index.jsp" method="GET">
                <input type="submit" value="Volver al catálogo" class="boton_personalizado">
                </form>
        <%
            }
        %>
        <p>
            <br>
        </p>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
