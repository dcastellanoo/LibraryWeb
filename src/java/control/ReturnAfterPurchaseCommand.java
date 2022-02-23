package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import model.ShoppingCart;

public class ReturnAfterPurchaseCommand extends FrontCommand{

    @Override
    public void process() {
        ShoppingCart cart = new ShoppingCart();
        session.setAttribute("cart", cart);
        
        try {
            forward("/index.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(ReturnAfterPurchaseCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReturnAfterPurchaseCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
