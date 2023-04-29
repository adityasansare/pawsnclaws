package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register3")
public class DomesticServlet extends HttpServlet{
	
	
	//create the query
	private static final String INSERT_QUERY = " INSERT INTO DOMESTIC(NAME,CITY,CONTACT,ANIMAL,PIN) VALUES(?,?,?,?,?)";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//printwriter
		PrintWriter pw = res.getWriter();
		//content type
		res.setContentType("text/html");
		//read the form values
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		String contact = req.getParameter("contact");
		String animal = req.getParameter("animal");
		String pin = req.getParameter("pin");

		
		
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create a connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///claws","root","JaiHanuman@13");
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
			//set the values
			ps.setString(1, name);
			ps.setString(2, city);
			ps.setString(3, contact);
			ps.setString(4, animal);
			ps.setString(5, pin);

			
			
			//execute the query
			int count= ps.executeUpdate();
			if(count==0) {
				pw.println("Record not Stored into Database");
			}else {
				pw.println("<link rel=\"icon\" href=\"https://cdn.discordapp.com/attachments/963083724755451944/1022555292166275092/unknown.png\" type=\"image\">");
				pw.println("<title>Paws & Claws</title>");
				pw.println("<body>");

				pw.println("  <link rel=\"icon\" href=\"https://cdn.discordapp.com/attachments/963083724755451944/1022555292166275092/unknown.png\" type=\"image\">\r\n"
						+ "<title>Paws & Claws</title>\r\n"
						+ "    <style>\r\n"
						+ "        #pawsandclaws {\r\n"
						+ "          max-width: 15%; \r\n"
						+ "          height: auto;\r\n"
						+ "        }\r\n"
						+ "      </style>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "<header class=\"text-gray-600 body-font\">\r\n"
						+ "\r\n"
						+ "    <body>\r\n"
						+ "        <div class=\"container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center\">\r\n"
						+ "            <a class=\"flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0\" href=\"index.html\">\r\n"
						+ "                <img id=\"pawsandclaws\" src=\"https://cdn.discordapp.com/attachments/963083724755451944/1022555292166275092/unknown.png\" alt=\"hehe\">\r\n"
						+ "                <span class=\"ml-3 text-xl\">Paws & Claws</span>\r\n"
						+ "            </a>\r\n"
						+ "            <nav class=\"md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center\">\r\n"
						+ "                <a class=\"mr-5 hover:text-gray-900\" href=\"index.html\">Home</a>\r\n"
						+ "                <a class=\"mr-5 hover:text-gray-900\" href=\"volunteer.html\">Volunteer</a>\r\n"
						+ "                <a class=\"mr-5 hover:text-gray-900\" href=\"about.html\">About Us</a>\r\n"
						+ "                <a class=\"mr-5 hover:text-gray-900\" href=\"contact.html\">Contact Us</a>\r\n"
						+ "            </nav>\r\n"
						+ "        </div>\r\n"
						+ "\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "</head>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "<script src=\"https://cdn.tailwindcss.com\"></script>\r\n"
						+ "\r\n"
						+ "</html>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "");
				pw.println("<br>");
				pw.println("<br>");
				pw.println("<br>");
				pw.println("<center>");
				pw.println("<h1>Record Stored into Database<h1>");
				pw.println("<br>");

//				pw.println("<button style=\"width:220px; text-align:center; background-color: rgb(20, 165, 255); color:black; padding:20px; height:fit-content \"><a href=index.html >Back to Home Page </a></button>");
				pw.println("</center>");
				
				pw.println("</body>");
				
//				pw.println("<script src=\"https://cdn.tailwindcss.com\"></script>");
			}
			
			
		}catch( SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
			
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace(); 
		}
		
		
		//close the string
		pw.close();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}