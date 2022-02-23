package model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Book, Integer> shoppingList;
    private int numBooks;

    public ShoppingCart() {
        this.shoppingList = new HashMap<Book, Integer>();
        this.numBooks = 0;
    }

    public Map<Book, Integer> getShoppingList() {
        return shoppingList;
    }

    public int getNumBooks() {
        return numBooks;
    }
    
    public void addBookToCart(Book b){
        if (shoppingList.containsKey(b)){
            shoppingList.put(b, shoppingList.get(b) + 1);
        } else {
            shoppingList.put(b, 1);
        }
        this.numBooks++;
    }
    
    public void removeBookCart(Book b){
        int n = shoppingList.get(b);
        if (n > 1){
            shoppingList.put(b, n - 1);
        } else {
            shoppingList.remove(b);
        }
        this.numBooks--;
    }
    
    public double getCartCost(){
        double cost = 0.0;
        for (Book b : this.shoppingList.keySet()){
            cost += b.getPrice() * this.shoppingList.get(b);
        }
        return cost;
    }
}
