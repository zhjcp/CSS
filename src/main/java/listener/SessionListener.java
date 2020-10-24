package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
* 作用：监听器
*           统计网站的实时在线人数
* ps：按这种方式实现监听器会导致人数比实际人数+1，注意处理一下就好
* */
public class SessionListener implements HttpSessionListener {
    @Override
    //创建session监听
    //一旦创建session就会触发一次这个监听事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount==null){
            //第一个人登录 1
            onlineCount=new Integer(1);
        }else {
            //其他人登录 +1
            onlineCount=new Integer(onlineCount.intValue()+1);
        }

        servletContext.setAttribute("onlineCount",onlineCount);
    }

    @Override
    //销毁session监听
    //一旦销毁session就会触发一次这个监听事件
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("====================");
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount==null){
            onlineCount=new Integer(0);
        }else {
            onlineCount=new Integer(onlineCount.intValue()-1);
        }

        servletContext.setAttribute("onlineCount",onlineCount);
        
    }
}
