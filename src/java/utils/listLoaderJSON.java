package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import model.Catalogue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class listLoaderJSON implements listLoader{
    private String JSONpath;

    public listLoaderJSON(String JSONpath) {
        this.JSONpath = JSONpath;
    }
    
    @Override
    public Catalogue getBookList() {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            Object ob = new JSONParser().parse(new FileReader(this.JSONpath));
            JSONArray array = (JSONArray) ob;
            Iterator<JSONObject> iterator = array.iterator();
            JSONObject o;
            
            while (iterator.hasNext()){
                double price = Math.round(Math.random()*(60 - 7) + 7);
                o = (JSONObject) iterator.next();
                bookList.add(new Book((String) o.get("title"), (String) o.get("isbn"), (Long) o.get("pageCount"), 
                (String) o.get("thumbnailUrl"), (String) o.get("shortDescription"), (ArrayList) o.get("authors"), 
                        (ArrayList) o.get("categories"), price));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(listLoaderJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(listLoaderJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Catalogue(bookList);   
    }
    
}
