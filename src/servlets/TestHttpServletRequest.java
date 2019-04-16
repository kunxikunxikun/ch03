import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestHttpServletRequest
 */
@WebServlet("/TestHttpServletRequest")
public class TestHttpServletRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestHttpServletRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println(request.getHeader("host"));//获取 主机名和端口号
		System.out.println(request.getHeader("user-agent"));//获取
		System.out.println(request.getMethod());
		
		
//		***读取上下文路径
		System.out.println(request.getContextPath());
//		***读取当前Servlet地址
		System.out.println(request.getServletPath());
		
//		***解决请求参数化中有中文的乱码问题   必须放在所有的getParameter 之前
//		request.setCharacterEncoding("UTF-8");
		
		
//		***读取请求参数值
		String username = request.getParameter("username");//只能读单值参数   不能读取多值请求参数值  （一个名对一个值   ，文本框、单选按钮、单选下拉列表）
		String age = request.getParameter("age");
		System.out.println("username:"+username+";age:"+age);
//		***读取多值请求参数（一个名对多个值，复选框、多选下拉列表）
		String[] uname = request.getParameterValues("username");   //这里需要用字符串数组进行 获取    获取到的是一个字符串数组
		if(uname!=null) {
			for(int i=0;i<uname.length;i++) {
				System.out.print("username:"+uname[i]);
			}
		}
		

		
		
		
		
//		获取所有请求参数名
//		Enumeration   Java中的枚举类型
		Enumeration<String> paramNames =  request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String curName= (String)paramNames.nextElement();
			String curValue=request.getParameter (curName);
			System.out.println("参数名为"+curName+"的 参数值："+curValue);
		}
/**		
 * 		A和B  共享一块内存  A将数据存进去   B将数据取出来   就能做到数据的传输
 * 		
 * 		想请求有效范围存储数据（格式：键/值---key/value）
 * 		
 * */	
//		***从请求有效范围内写入数据
		request.setAttribute("param", username);
		
//		***实现Web资源间跳转：第一种是   请求转发方式（forward）的跳转    一般跳转语句 是写在  最后
//		***1.跳转前后的程序位于同一次请求连接范围内
//		*** Request 访问A 跳转到  B返回Responce
/*		***2.只能在同一个Web应用内跳转（站内跳转）
 * 		***3.跳转后浏览器地址保持不变 
 * 		
 * */		
		request.getRequestDispatcher("/AnotherServlet").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
