



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String pin = request.getParameter("pin");
		out.print("<p><p>");
		out.print("<body>");
		out.print("  <link rel=\"icon\" href=\"https://cdn.discordapp.com/attachments/963083724755451944/1022555292166275092/unknown.png\" type=\"image\">\r\n"
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
				+ "            <button\r\n"
//				+ "                class=\"inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0\">Button\r\n"
				+ "                <svg fill=\"none\" stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\"\r\n"
				+ "                    class=\"w-4 h-4 ml-1\" viewBox=\"0 0 24 24\">\r\n"
				+ "                    <path d=\"M5 12h14M12 5l7 7-7 7\"></path>\r\n"
				+ "                </svg>\r\n"
				+ "            </button>\r\n"
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
		out.print("</body>");
		out.println("<center>");
//		out.println("<h1>Details of Volunteers</h1>");
		out.println("<br>");
	


		out.print("<table border = '4'><tr><th class=\"px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl\">Name</th><th class=\"px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl\">City</th><th class=\"px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl\">Contact</th><th class=\"px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl\">Animal</th></tr>");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/claws","root","JaiHanuman@13");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select*from reptiles where pin="+pin+"");
			
			while(rs.next()) {
				
				out.print("<tr><td class=\"border-t-2 border-gray-200 px-4 py-3\">");
				out.print(rs.getString(1));
				out.print("</td>");
				out.print("<td class=\"border-t-2 border-gray-200 px-4 py-3\">");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td class=\"border-t-2 border-gray-200 px-4 py-3\">");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td class=\"border-t-2 border-b-2 border-gray-200 px-4 py-3 text-lg text-gray-900\">");
				out.print(rs.getString(4));
				out.print("</td>");
//				out.print("<td class=\"border-t-2 border-b-2 border-gray-200 w-10 text-center\">");
				out.print("</tr>");
				
			}
			
		}catch (Exception p) {
			System.out.println(p);
		}
		
		out.print("</table>");
		out.println("<link rel=\"icon\" href=\"https://cdn.discordapp.com/attachments/963083724755451944/1022555292166275092/unknown.png\" type=\"image\">");
		out.println("<title>Paws & Claws</title>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<br>");

//		out.println("<button style=\"width:220px; text-align:center; background-color: rgb(20, 165, 255); color:black; padding:20px; height:fit-content \"><a href=index.html >Back to Home Page </a></button>");
		out.println("</center>");
//		out.println("<script src=\"https://cdn.tailwindcss.com\"></script>");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

