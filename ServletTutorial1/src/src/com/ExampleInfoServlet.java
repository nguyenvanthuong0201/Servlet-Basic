package src.com;
import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

	@WebServlet("/other/exampleInfo")
	public class ExampleInfoServlet extends HttpServlet {
	private static final long serialVersionUIL=1L;
	public ExampleInfoServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServerException,IOException {
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<style> span {color:blue;} </style>");
		String requestURL=request.getRequestURL().toString();
		out.println("<br><span>requestURL: </span>");
		out.println(requestURL);
		
		String requestURI=request.getRequestURI();
		out.println("<br><span>requestURl: </span>");
		out.println(requestURI);
		//String text1=this.getServletConfig().getInitParameter("text1");
		//String text2=this.getServletConfig().getInitParameter("text2");
		//out.println("<br><span>text1,text2 :</span>");
		//out.println(text1);
		//out.println(text2);
	    
		String queryString = request.getQueryString();
	        out.println("<br><span>queryString:</span>");
	        out.println(queryString);
	 
	        String param1 = request.getParameter("text1");
	        out.println("<br><span>getParameter text1:</span>");
	        out.println(param1);
	 
	        String param2 = request.getParameter("text2");
	        out.println("<br><span>getParameter text2:</span>");
	        out.println(param2);
		
		  out.println("<br><span>serverName:</span>");
	        String serverName = request.getServerName();
	        out.println(serverName);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
