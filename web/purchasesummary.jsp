<%-- 
    Document   : purchasesummary
    Created on : 18-feb-2022, 10:42:17
    Author     : diego
--%>

<%@page import="model.Book"%>
<%@page import="model.ShoppingCart"%>
<%@page import="model.Catalogue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Purchase</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <center><h1>Resumen de compra</h1></center>

        <center><table>
        <thead>
          <tr>
            <th>Cant.</th>
            <th>Producto</th>
            <th>Precio Unitario</th>
            <th>Importe</th>
          </tr>
        </thead>
        <tbody>
            <%
            for (Book b : cart.getShoppingList().keySet()){ %> 
                <tr>
                <td><%= cart.getShoppingList().get(b)%></td>
                <td><%= b.getTitle() %></td>
                <td><%= b.getPrice() %> $</td>
                <td><%= b.getPrice()  * cart.getShoppingList().get(b)%> $</td>
                </tr>
            <%       
                }
            %>
            
        </tbody>
        <tfoot>
          <tr>
            <th></th>
            <th></th>
            <th>Total Factura</th>
            <th><%= cart.getCartCost() %> $</th>
          </tr>
        </tfoot>
        </table></center><br>
    </div>
        <center><form action="purchasedone.jsp" method="GET">
                <input type="submit" value="Pagar" style="height:50px; width:200px" class="boton_personalizado">
                </form></center>
        <center><form action="cart.jsp" method="GET">
                <input type="submit" value="Volver" style="height:50px; width:200px" class="boton_personalizado">
                </form></center>
        <p>
            <br>
        </p>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
