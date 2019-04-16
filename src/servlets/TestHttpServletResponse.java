import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestHttpServletResponse
 */
@WebServlet("/TestHttpServletResponse")
public class TestHttpServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestHttpServletResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		***获取输出流对象   有缓冲区   默认带的缓冲区是8k    缓冲区满了  向客户端发送数据    如果没满   可以用 flush() 进行缓冲区刷新

//		设置响应字符集（解决响应中含有中文乱码问题）
		response.setContentType("text/html;charset=UTF-8");
		
		
//		PrintWriter   缓冲流的一种    获取输出流对象
		PrintWriter out = response.getWriter();
		out.print("hello world!<br>");
		out.print("你好，世界！");
//		out.flush();
		
		request.setAttribute("param", "您好");
		
//		重定向
/**		1.跳转前后的程序不属于同一个请求有效范围内
 * 		2.可以跳转到其他应用的程序（可以做到站外跳转）
 * 		3.跳转后浏览器地址栏地址变为跳转后的目的地地址 
 * */		
//		response.sendRedirect("/Ch03/AnotherServlet");
		response.sendRedirect(request.getContextPath()+"/AnotherServlet");
		
//		只要响应到了客户端  就什么都做不了了，做任何事情都要在强制刷新之前   
		out.flush();
		
		
		
		
		
		
		
		
	}
	
	

	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
