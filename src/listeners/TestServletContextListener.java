import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestServletContextListener
 *
 */
@WebListener
public class TestServletContextListener implements ServletContextListener,ServletContextAttributeListener{

    /**
     * Default constructor. 
     */
    public TestServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
//    	销毁的时候自动被调用的方法
        System.out.println("------ServletContext对象被销毁------");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
//    	初始化的时候被调用的方法
    System.out.println("------ServletContext对象被创建------");
    }
    
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
        // TODO Auto-generated method stub
    	System.out.println("应用有效中新增了属性，属性名："+arg0.getName()+",属性值"+arg0.getValue());
   }

	/**
    * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
    */
   public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
        // TODO Auto-generated method stub
   }

	/**
    * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
    */
   public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
        // TODO Auto-generated method stub
   }
	
}
