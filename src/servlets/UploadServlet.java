import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/** Servlet implementation class UploadServlet */
@WebServlet("/UploadServlet")
// 只要是做上传功能的 都需要进行添加此注解
@MultipartConfig
public class UploadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /** @see HttpServlet#HttpServlet() */
  public UploadServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // response.getWriter().append("Served at: ").append(request.getContextPath());
    String name = request.getParameter("username"); // 读取表单输入的参数   只能读单值参数
    Part part = request.getPart("img"); // 现在只是 读取了那个文件  并没有将文件写入到服务器中

    String path = FileUploadUtil.uploadSingleFile(part, request);
    System.out.println(path);

    /** 响应中有中文 设置 响应字符集为UTF-8 */
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter(); // 得到输出流   PrintWriter 是打印流
    if (path != null) {
      out.print("上传文件成功，上传者为：" + name + "上传文件名为:" + path);
    } else {
      out.print("上传文件失败！");
    }
  }

  /** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
