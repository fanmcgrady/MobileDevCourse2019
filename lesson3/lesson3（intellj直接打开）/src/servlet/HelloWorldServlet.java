package servlet;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author fangzhiyang
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 设置编码，保证中文不要出现乱码
        req.setCharacterEncoding("utf-8");
        res.setCharacterEncoding("utf-8");
        
        // 设置返回是json格式
        res.setContentType("application/json");
        
        // 接收前端参数
        String studentId = req.getParameter("studentId");
        System.out.println(studentId);
        String comment = req.getParameter("comment");
        System.out.println(comment);
        

        JSONObject userResult = null;

        // 根据参数请求数据
        // 常规应该根据自己的业务逻辑来取数据
        if ("1".equals(studentId)) {
            bean.UserInfo userInfo = new bean.UserInfo();
            userInfo.setName("张三");
            userInfo.setIdCard("123");

            bean.UserDetail detail = new bean.UserDetail();
            detail.setHeight("183");
            detail.setWidth("70");

            userInfo.setUserDetail(detail);

            userResult = new JSONObject(userInfo);

        } else {
            System.out.println("用户不存在");
        }
        
        // 返回结果
        res.getWriter().print(userResult);
//        res.getWriter().print("success");
    }
}
