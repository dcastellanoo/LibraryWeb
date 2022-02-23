package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
    
    abstract public void process();
    
    public void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = context.getRequestDispatcher(target);
        dp.forward(request, response);
    }
}
