package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import model.ShoppingCart;

public class ClearCartCommand extends FrontCommand {

    @Override
    public void process() {
        ShoppingCart cart = new ShoppingCart();
        session.setAttribute("cart", cart);
        
        try {
            forward("/cart.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(ClearCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClearCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
