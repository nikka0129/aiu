package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/pkg1/search"})
public class Search extends HttpServlet {

public void doPost (
HttpServletRequest request, HttpServletResponse response
) throws ServletException, IOException {
PrintWriter out=response.getWriter();
Page.index(out);
try {
	InitialContext ic=new InitialContext();
	DataSource ds=(DataSource)ic.lookup(
			"java:/comp/env/jdbc/book");
	Connection con=ds.getConnection();
	
	String keyword=request.getParameter("keyword");
	
	PreparedStatement st=con.prepareStatement(
			"select * from uma1 where name like ?");
	st.setString(1, "%"+keyword+"%");
	ResultSet rs=st.executeQuery();
	
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset='utf-8'>");
	out.println("<title>検索結果</title>");
	out.println("<link href='css/style.css' rel='stylesheet' type='text/css'>");
	
	out.println("</head>");
	out.println("<body>");
	out.println("<header class=\"header_top\">");
	
	out.println("<article class=\"article_top\">");
	out.println("<section class=\"section_top3\">");
	out.println("<h1>");
	out.println("検索結果");
	out.println("</h1>");
	

	
	while (rs.next()) {
		
		
		out.println(rs.getInt("id"));
		out.println(":");
		out.println(rs.getString("name"));
		
		
		out.println("<br>");
			
}
	out.println("</section>");
	out.println("</article>");
	out.println("</html>");
	out.println("</body>");
	out.println("</html>");
	st.close();
	con.close();
} catch (Exception e) {
		e.printStackTrace(out);
}
Page.footer(out);
}
}