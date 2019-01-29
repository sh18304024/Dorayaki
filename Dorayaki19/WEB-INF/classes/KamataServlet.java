import javax.servlet.http.HttpServlet;	//�K�{�ȃC���|�[�g��
import javax.servlet.http.HttpServletRequest;	//�K�{�ȃC���|�[�g��
import javax.servlet.http.HttpServletResponse;	//�K�{�ȃC���|�[�g��
import javax.servlet.ServletException;	//�K�{�ȃC���|�[�g��
import javax.servlet.RequestDispatcher;	//�K�{�ȃC���|�[�g��
import java.io.IOException;		//�K�{�ȃC���|�[�g��
import java.io.PrintWriter;		//�K�{�ȃC���|�[�g��
import info.Profile;	//�K�{�ȃC���|�[�g��
import database.InsertTest;	//�K�{�ȃC���|�[�g��
import database.QueryTest;	//�K�{�ȃC���|�[�g��
import java.util.List;

public class KamataServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		//�p�����[�^���󂯎�肽��
		req.setCharacterEncoding("Windows-31J"); //
	
		String name = req.getParameter("name");//
		String pass = req.getParameter("pass");//
		
		//�f�[�^�x�[�X���������݂����B
		InsertTest.insertUser_Table(name,pass);
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Profile> plist = getList();
		//�p�����[�^�[��JSP�ɓ]��������
		
		
		//�T�[�u���b�g�̎��p�����[�^��JSP�]�������ɃZ�b�g
		
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��B
		RequestDispatcher dis = req.getRequestDispatcher("/list");
	
		//JSP�ɓ]��
		dis.forward(req,res);
	
	}
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Profile> plist = getList();
		//�p�����[�^�[��JSP�ɓ]��������
		
		
		//�T�[�u���b�g�̎��p�����[�^��JSP�]�������ɃZ�b�g
		
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��B
		RequestDispatcher dis = req.getRequestDispatcher("/list");
	
		//JSP�ɓ]��
		dis.forward(req,res);
	}	
	public List<Profile> getList(){
		List <Profile> plist = QueryTest.getQueryList();
		return plist;
	}
}

