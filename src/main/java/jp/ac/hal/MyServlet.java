package jp.ac.hal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.getWriter().append("Served at: ").append(request.getContextPath());
  
  try {
   //DB接続管理クラス
   Connection c = null;
   
   //DB接続用のドライバを読み込む
   Class.forName("com.mysql.jdbc.Driver");
   
   //DB接続情報
   String url = "jdbc:mysql://localhost:3306/cs15";
   String dbUser = "root";
   String dbPassword = "";
   
   /*
   //DB接続
   c = DriverManager.getConnection(url,dbUser,dbPassword);
   
   //SQL作成
   String sql = "INSERT INTO users VALUES(NULL,?,?,?)";
   
   //プリペアードステートメントの準備（セキュ向上）
   PreparedStatement ps = c.prepareStatement(sql);
   
   //プレースホルダ（仮置き場(SQlの？)）の値設定
   ps.setString(1,"aaa");
   ps.setString(2, "bbb");
   ps.setInt(3, 30);
   
   //SQLの発行
   ps.executeUpdate();
   
   //プリペードステートメントの切断
   ps.close();
   
   //DB切断
   c.close();
   */
   
   //DB接続
   c = DriverManager.getConnection(url,dbUser,dbPassword);
   
   //SQL作成
   String sql = "SELECT * FROM users";
   
   //プリペアードステートメントの準備（セキュ向上）
   PreparedStatement ps = c.prepareStatement(sql);
   
   //プレースホルダ（仮置き場(SQlの？)）の値設定
//   ps.setString(1,"aaa");
//   ps.setString(2, "bbb");
//   ps.setInt(3, 30);
   
   //SQLの発行
   ResultSet rs = ps.executeQuery();
   
   //存在するレコード数分繰り返す
   while(rs.next()) {
    //1列目のデータ取得
    System.out.print(rs.getInt(1));
    
    //2列目のデータ取得
    System.out.print(rs.getString(2));
    
    //3列目のデータ取得
    System.out.print(rs.getString("password"));
    
    //4列目のデータ取得
    System.out.print(rs.getInt("age"));
   }
   //Resultsetの切断
   rs.close();
   
   //プリペードステートメントの切断
   ps.close();
   
   //DB切断
   c.close();
  } catch (Exception e) {
   // TODO 自動生成された catch ブロック
   e.printStackTrace();
  }
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(request, response);
  
 }

}