package servlet;

import bean.User;
import bean.UserDetail;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fangzhiyang
 */
@WebServlet("/lesson2")
public class Lesson2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        System.out.println(userId);

        // ....  根据userId请求Database

        User user = new User();
        user.setName("张三");
        user.setSex(1);

        UserDetail userDetail = new UserDetail();
        userDetail.setId(userId);
        userDetail.setPhone("13550345266");
        user.setDetail(userDetail);

        JSONObject jsonObject = new JSONObject(user);

        System.out.println(jsonObject);

        // 返回前台
        resp.getWriter().print(jsonObject);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        System.out.println(userId);
        
        // ....  根据userId请求Database

        User user = new User();
        user.setName("张三");
        user.setSex(1);

        UserDetail userDetail = new UserDetail();
        userDetail.setId(userId);
        userDetail.setPhone("13550345266");
        user.setDetail(userDetail);

        JSONObject jsonObject = new JSONObject(user);
        
        // 返回前台
        resp.getWriter().print(jsonObject);
    }
}
