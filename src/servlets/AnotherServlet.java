import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnotherServlet
 */
@WebServlet("/AnotherServlet")
public class AnotherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		***从请求有效范围中读取数据
		String param=(String)request.getAttribute("param");
		System.out.println("request范围中的param："+param);
		
//		***从会话有效范围中读取数据
		HttpSession session = request.getSession();
		
		String param1 =(String)session.getAttribute("param");

		
		System.out.println("session范围内的param:"+param1);
		
//		***从应用有效范围中获取数据
		ServletContext sc = request.getServletContext();
		String param2 =(String)sc.getAttribute("param");
		System.out.println("servletcontext范围中的param"+param2);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
