<%-- 
    Document   : purchasedone
    Created on : 18-feb-2022, 16:49:00
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>PurchaseDone</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <center><h1>¡Gracias por su compra!</h1></center>
        <center><form action="FrontController" method="GET">
                    <input type="hidden" name="command" value="ReturnAfterPurchaseCommand">
                    <input type="submit" value="Volver al catálogo" class="boton_personalizado" style="height:50px; width:200px">
                    </form></center>
        <p>
            <br>
        </p>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
