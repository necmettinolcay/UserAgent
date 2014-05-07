package com.test.servlet;

import java.io.IOException;
//import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class browserServlet
 */
@WebServlet("/browserServlet")
public class browserServlet extends HttpServlet {
	 @Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
     }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		
		String browserDetails = request.getHeader("User-Agent");
		String userAgent = browserDetails;
		String user = userAgent.toLowerCase();
		String browser = "";
		String os = " ";
// ------------------------os------------------------------		
		if(user.indexOf("windows") >= 0){
			os = "windows";
		}
		else if(user.indexOf("mac") >= 0){
			os = "mac";
		}
		else if(user.indexOf("x11c") >= 0){
			os = "Unix";
		}
		else if(user.indexOf("android") >= 0){
			os = "android";
		}
		else if(user.indexOf("iphone") >= 0){
			os = "iphone";
		}
		else {
			os = "Unknow,More info "+userAgent;
		}
		
// ---------------------browser----------------------------    		
		if (user.contains("msie"))
        {
            browser = "msi";
            
        }
        else if (user.contains("safari") && user.contains("version"))
        {
           browser = "Safari";
         
        }
        else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("Opera"))
                browser = "Opera";
            else if(user.contains("OPR"))
                browser= "Opera";
        }
        else if (user.contains("chrome"))
        {
            browser="Chrome"; 
         }
        else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
            browser = "Netscape-?";

        }
        else if (user.contains("firefox"))
        {
            browser="Firefox";
           
        }
        else
        {
            browser = "UnKnown";
        }
// -------------------sendRedirect------------------------		
		
		if (os == "windows" || os == "Unix" || os == "mac"){
			switch(browser){
			case "Chrome":
				response.sendRedirect("http://www.google.com");
				break;
			case "Firefox":
				response.sendRedirect("http://www.mozilla.org");
				break;
			case "Opera":
				response.sendRedirect("http://www.opera.com");
				break;
			case "Safari":
				response.sendRedirect("http://www.apple.com");
				break;
			case "UnKnown":
				response.sendRedirect("http://www.microsoft.com");
				break;
			
		 }
			
			
		}
		else {
			 switch(browser){
			 case "Chrome":
					response.sendRedirect("http://www.m.google.com");
					break;
				case "Firefox":
					response.sendRedirect("http://www.m.mozilla.org");
					break;
				case "Opera":
					response.sendRedirect("http://www.m.opera.com");
					break;
				case "Safari":
					response.sendRedirect("http://www.m.apple.com");
					break;
				case "msi":
					response.sendRedirect("http://www.m.microsoft.com");
					break;
			}
		}
		
		
	}

}
