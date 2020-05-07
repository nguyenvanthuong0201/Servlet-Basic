package com;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "*.png", "*.jpg", "*.gif" }, initParams = {
        @WebInitParam(name = "notFoundImage", value = "/Images/non-pic.jpg") })
public class ImageFilter implements Filter{
		private String notFoundImage;
		public ImageFilter() {}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		notFoundImage=filterConfig.getInitParameter("notFoundImage");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req= (HttpServletRequest)request;
		String servletPath= req.getContextPath();
		String servletRootPath=request.getServletContext().getRealPath("");
		String imagesRealRoot = servletRootPath + servletPath;
		
		System.out.println("-servlet: "+imagesRealRoot);
		File file = new File(imagesRealRoot);
		if(file.exists())
		{
			chain.doFilter(request, response);
		}
		else if(!servletPath.equals(notFoundImage))
		{
			HttpServletResponse resp =(HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+ this.notFoundImage);
		}
	}	
} 

