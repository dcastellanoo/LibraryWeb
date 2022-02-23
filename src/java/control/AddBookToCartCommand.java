package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import model.Book;
import model.Catalogue;
import model.ShoppingCart;

public class AddBookToCartCommand  extends FrontCommand {

    @Override
    public void process() {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Catalogue catalogue = (Catalogue) session.getAttribute("catalogue");
        String isbn = (String) request.getParameter("isbn");
        Book b = catalogue.findBookByIsbn(isbn);
        cart.addBookToCart(b);
        try {
            forward("/index.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(AddBookToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddBookToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
