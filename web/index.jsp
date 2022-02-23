<%-- 
    Document   : cataloguejsp
    Created on : 16-feb-2022, 16:17:03
    Author     : diego
--%>

<%@page import="model.Book"%>
<%@page import="model.Catalogue"%>
<%@page import="utils.listLoaderJSON"%>
<%@page import="model.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    listLoaderJSON listLoader = new listLoaderJSON("C:\\Users\\diego\\Documents\\NetBeansProjects\\LibraryWeb\\web\\static\\books_ulr.json");
    Catalogue catalogue = listLoader.getBookList();
%> 

<% 
   session.setAttribute("catalogue", catalogue);
   if (session.getAttribute("cart") == null){
       ShoppingCart cart = new ShoppingCart();
       session.setAttribute("cart", cart);
   } else {
       ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
   }
%>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Catalogue</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1 class="h1tittles"><center>CATÁLOGO</center></h1>
        <%
            for (Book b : catalogue.getBookList()){ %> 
        
            <div class="bookDisplay" >
                <p>
                    <br>
                </p>
                <center><h2><b> <%= b.getTitle() %> </h2></b></center>
                <center><img src = "<%= b.getImageURL() %>" width ="150" height = "188"></center> <br>
                <center><b>Precio:</b> <%= b.getPrice() %> $</center><br>
                <b> ISBN: </b> <%= b.getIsbn() %> <br>
                
                <% if (b.getDescription() != null) {
                %><b>Descripción:</b> <%= b.getDescription() %> <br><%
                }%>
                
                <% if (b.getPageCount() != 0) {
                %><b>Número de páginas:</b> <%= b.getPageCount() %> <br><%
                }%>
                
                <b>Autor/es:</b> <%= b.getAuthors() %> <br>
                <b>Categorias:</b> <%= b.getCategories() %> <br>
                
                <center><form action="FrontController" method="GET">
                    <input type="hidden" name="command" value="AddBookToCartCommand">
                    <input type="hidden" name="isbn" value= <%= b.getIsbn() %> >
                    <input type="submit" value="Añadir al carrito" style="height:50px; width:200px"  class="boton_personalizado">
                    <p>
                        <br>
                    </p>
                </form></center>
            </div>

        <%       
            }
        %>
        <jsp:include page="footer.jsp"></jsp:include>        
        <p>
            <br>
        </p>

    </body>
</html>
