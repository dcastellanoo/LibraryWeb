package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Book;
import model.Catalogue;
import utils.listLoaderJSON;
import model.ShoppingCart;

public final class catalogue_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   ShoppingCart cart = new ShoppingCart();
   listLoaderJSON listLoader = new listLoaderJSON("C:\\Users\\diego\\Documents\\NetBeansProjects\\LibraryWeb\\web\\static\\books_ulr.json");
   Catalogue catalogue = listLoader.getBookList();

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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write(' ');
      out.write('\n');

    session.setAttribute("catalogue", catalogue);
    session.setAttribute("cart", cart);

      out.write("\n");
      out.write("    \n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Catalogue</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1><center>Library</center></h1>\n");
      out.write("        ");

            for (Book b : catalogue.getBookList()){ 
      out.write(" \n");
      out.write("            <p>                \n");
      out.write("                <h2><b> ");
      out.print( b.getTitle() );
      out.write(" </h2></b>\n");
      out.write("                <img src = \"");
      out.print( b.getImageURL() );
      out.write("\" width =\"150\" height = \"188\"> <br>\n");
      out.write("                <b> ISBN: </b> ");
      out.print( b.getIsbn() );
      out.write(" <br>\n");
      out.write("                <b>Description:</b> ");
      out.print( b.getDescription() );
      out.write(" <br>\n");
      out.write("                <b>Page Count:</b> ");
      out.print( b.getPageCount() );
      out.write(" <br>\n");
      out.write("                <b>Author/s:</b> ");
      out.print( b.getAuthors() );
      out.write(" <br>\n");
      out.write("                <b>Categories:</b> ");
      out.print( b.getCategories() );
      out.write(" <br>\n");
      out.write("                <b>PVP:</b> ");
      out.print( b.getPrice() );
      out.write(" $<br>\n");
      out.write("                <form action=\"FrontController\" method=\"GET\">\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"AddBookToCartCommand\">\n");
      out.write("                    <input type=\"hidden\" name=\"isbn\" value= ");
      out.print( b.getIsbn() );
      out.write(" >\n");
      out.write("                    <input type=\"submit\" value=\"Add book to cart\">\n");
      out.write("                </form>\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("        ");
       
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
