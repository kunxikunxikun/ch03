import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Servlet implementation class TestCookie */
@WebServlet("/TestCookie")
public class TestCookie extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /** @see HttpServlet#HttpServlet() */
  public TestCookie() {
    super();
    // TODO Auto-generated constructor stub
  }

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    //		response.getWriter().append("Served at: ").append(request.getContextPath());

    Cookie cookie = new Cookie("college", "neusoft"); // 导入要导入  servlet.http中的包
    cookie.setMaxAge(7 * 24 * 60 * 60); // 这是生存一周的生存时间

    Cookie cookie2 = new Cookie("season", "spring");
    cookie2.setMaxAge(500);

    response.addCookie(cookie);
    response.addCookie(cookie2); // 利用响应向客户端 保存两个cookie

    Cookie[] cookies = request.getCookies(); // 不需要参数  一次性将客户端中的cookie全部读出来
    if (cookies != null) {
      for (Cookie c : cookies) { // 相当于 for(int i =0 ;i<cookies.length;i++)
        System.out.println("key:" + c.getName() + "value:" + c.getValue());
      }
    }
  }

  /** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
