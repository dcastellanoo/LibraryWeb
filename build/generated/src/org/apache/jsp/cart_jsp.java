package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Book;
import model.ShoppingCart;
import model.Catalogue;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    Catalogue catalogue = (Catalogue) session.getAttribute("catalogue");
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ShoppingCart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>ShoppingCart</h1>\n");
      out.write("        ");

            if (cart.getNumBooks() != 0){
                for (Book b : cart.getShoppingList().keySet()){ 
      out.write(" \n");
      out.write("                <p>  \n");
      out.write("                    <img src = \"");
      out.print( b.getImageURL() );
      out.write("\" width =\"150\" height = \"188\" align = \"left\">\n");
      out.write("                    <h2><b> ");
      out.print( b.getTitle() );
      out.write(" </h2></b>\n");
      out.write("                    <b> ISBN: </b> ");
      out.print( b.getIsbn() );
      out.write(" <br>\n");
      out.write("                    <b>Price by unit:</b> ");
      out.print( b.getPrice() );
      out.write(" $<br>\n");
      out.write("                    <b>Unidades:</b> ");
      out.print( cart.getShoppingList().get(b) );
      out.write(" <br>\n");
      out.write("                    <form action=\"FrontController\" method=\"GET\">\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"IncrementBookCommand\">\n");
      out.write("                    <input type=\"hidden\" name=\"isbn\" value= ");
      out.print( b.getIsbn() );
      out.write(" >\n");
      out.write("                    <input type=\"submit\" value=\"Increment\">\n");
      out.write("                    <form action=\"FrontController\" method=\"GET\">\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"DecrementBookCommand1\">\n");
      out.write("                    <input type=\"hidden\" name=\"isbn\" value= ");
      out.print( b.getIsbn() );
      out.write(" >\n");
      out.write("                    <input type=\"submit\" value=\"Decrement\">\n");
      out.write("                    </form>\n");
      out.write("                </p>\n");
      out.write("        ");
       
                }
            } else {
                
      out.write("No ha añadido ningún libro");

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
