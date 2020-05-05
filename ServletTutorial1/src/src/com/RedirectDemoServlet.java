package src.com;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    

    protected void doGet(HttpServletRequest request ,HttpServletResponse response) 
    throws ServletException, IOException{
    	String redirect = request.getParameter("redirect");
    	if("true".equals(redirect))
    	{
    		System.out.println("redirect to ShowMe");
    		String ContextPath= request.getContextPath();
    		response.sendRedirect(ContextPath+"/showMe");
    		return;
    	}
    	ServletOutputStream out = response.getOutputStream();
    	out.println("<h3>Text of RedirectDemo </h3>");
    	out.println("-servlet : "+ request.getServletPath());
    	
    }
 
    protected void doPost(HttpServletRequest request ,HttpServletResponse response) 
    	    throws ServletException, IOException{
    	this.doGet(request, response);
    }
 
}
