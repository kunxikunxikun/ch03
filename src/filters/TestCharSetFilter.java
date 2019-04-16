import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestCharSetFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class TestCharSetFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestCharSetFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain

//		真正做事的方法
		
//		***解决请求参数化中有中文的乱码问题   必须放在所有的getParameter 之前
		request.setCharacterEncoding("UTF-8");
		
//		设置响应字符集（解决响应中含有中文乱码问题）    这里是在请求的时候就设置了 响应的字符编码
		response.setContentType("text/html;charset=UTF-8");
		
		chain.doFilter(request, response);//激活 这条链上的下一条 过滤器  如果没有 通过检查  就不调用这句话

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
