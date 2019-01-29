import javax.servlet.http.HttpServlet;	//必須なインポート文
import javax.servlet.http.HttpServletRequest;	//必須なインポート文
import javax.servlet.http.HttpServletResponse;	//必須なインポート文
import javax.servlet.ServletException;	//必須なインポート文
import javax.servlet.RequestDispatcher;	//必須なインポート文
import java.io.IOException;		//必須なインポート文
import java.io.PrintWriter;		//必須なインポート文
import info.Profile;	//必須なインポート文
import database.InsertTest;	//必須なインポート文
import database.QueryTest;	//必須なインポート文
import java.util.List;

public class KamataServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		//パラメータを受け取りたい
		req.setCharacterEncoding("Windows-31J"); //
	
		String name = req.getParameter("name");//
		String pass = req.getParameter("pass");//
		
		//データベースを書きこみたい。
		InsertTest.insertUser_Table(name,pass);
		
		//データベースからリストをもらいたい
		List<Profile> plist = getList();
		//パラメーターをJSPに転送したい
		
		
		//サーブレットの持つパラメータをJSP転送向けにセット
		
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定。
		RequestDispatcher dis = req.getRequestDispatcher("/list");
	
		//JSPに転送
		dis.forward(req,res);
	
	}
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	
		//データベースからリストをもらいたい
		List<Profile> plist = getList();
		//パラメーターをJSPに転送したい
		
		
		//サーブレットの持つパラメータをJSP転送向けにセット
		
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定。
		RequestDispatcher dis = req.getRequestDispatcher("/list");
	
		//JSPに転送
		dis.forward(req,res);
	}	
	public List<Profile> getList(){
		List <Profile> plist = QueryTest.getQueryList();
		return plist;
	}
}

