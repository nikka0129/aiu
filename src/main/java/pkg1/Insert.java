package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;


@WebServlet(urlPatterns={"/pkg1/insert"})
public class Insert extends HttpServlet {

public void doPost (
	HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			
			String login=request.getParameter("login");
			int password=Integer.parseInt(request.getParameter("password"));
			
			PreparedStatement st=con.prepareStatement(
					"insert into customer values(null, ?, ?)");
			st.setString(1, login);
			st.setInt(2, password);
			int line=st.executeUpdate();
			
			if (line>0) {
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='utf-8'>");
				out.println("<link href='css/style.css' rel='stylesheet' type='text/css'>");
				
				out.println("</head>");
				out.println("<body>");
				out.println("<header class=\"header_top\">");
				
				out.println("<article class=\"article_top\">");
				out.println("<section class=\"section_top3\">");
				out.println("追加に成功しました");
				out.println("<br>");
				
				
				out.println("<a href=\"login-in.jsp\">");
				out.println("ログイン");
				out.println("</a>");
				out.println("</section>");
				out.println("</article>");
				out.println("</html>");
				out.println("</body>");
				out.println("</html>");
			}
			
			st.close();
			con.close();
					
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
		
}

}
