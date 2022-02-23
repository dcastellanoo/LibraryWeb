package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import model.Book;
import model.ShoppingCart;

public class DecrementBookCommand extends FrontCommand{

    @Override
    public void process() {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        String isbn = (String) request.getParameter("isbn");
        for (Book b : cart.getShoppingList().keySet()){
            if (b.getIsbn().equals(isbn)){
                cart.removeBookCart(b);
                break;
            }
        }
        try {
            forward("/cart.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(DecrementBookCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DecrementBookCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
