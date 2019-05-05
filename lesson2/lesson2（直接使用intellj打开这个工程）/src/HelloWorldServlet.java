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
        // 接收前端参数
        String userId = req.getParameter("userId");

        JSONObject userResult = null;

        // 根据参数请求数据
        // 常规应该根据自己的业务逻辑来取数据
        if ("1".equals(userId)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName("张三");
            userInfo.setIdCard("123");

            UserDetail detail = new UserDetail();
            detail.setHeight(183);
            detail.setWidth(100);
            
            userInfo.setUserDetail(detail);

            userResult = new JSONObject(userInfo);
            
        } else {
            System.out.println("用户不存在");
        }
        
        // 返回结果
        res.getWriter().print(userResult);
    }
}
