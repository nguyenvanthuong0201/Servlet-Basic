package src.com;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        ServletOutputStream out = response.getOutputStream();
        HttpSession session = request.getSession();
        UserInfo userInfo =(UserInfo)session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo==null)
        {
        	response.sendRedirect(this.getServletContext().getContextPath()+"/login");
        	return;
        }
        out.println("<html>");
        out.println("<head><title>Session example</title></head>");
 
        out.println("<body>");
 
        out.println("<h3>User Info:</h3>");
 
        out.println("<p>User Name:" + userInfo.getUserName() + "</p>");
        out.println("<p>Country:" + userInfo.getCountry() + "</p>");
        out.println("<p>Post:" + userInfo.getPost() + "</p>");
 
        out.println("</body>");
        out.println("<html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	this.doGet(request, response);
    }
}
