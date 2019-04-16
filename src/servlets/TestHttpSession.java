import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testHttpSession
 */
@WebServlet("/TestHttpSession")
public class TestHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestHttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		***创建或获取session    如果不是第一次访问   就是创建连接      只有第一次建立连接的时候才是创建session  如果session存在，则返回当前窗口的sessionID
//		如果参数为false  如果session不存在，则返回null，如果session存在，则返回sessionID
		HttpSession session = request.getSession();
		System.out.println("session ID:"+session.getId());
		
		
		System.out.println("创建的时间："+session.getCreationTime());//默认是返回一个毫秒数    距离1970年1月1号0点的毫秒数
		
		System.out.println(session.getMaxInactiveInterval());//生存时间   默认是 1800s   30分钟
		
		//这个是小一点的
		request.setAttribute("param", "request范围中的param");
//		***想会话有效范围中存储数据    会话有效范围就是session
		//这个是大一点的
		session.setAttribute("param", "session范围中的param");
		
		
		response.sendRedirect("/Ch03/AnotherServlet");
		
//		从会话有效范围中删除数据   部分删除
//		session.removeAttribute("param");
		
		
////		***使session失效   全部删除   全部清空   整个失效
//		session.invalidate();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
