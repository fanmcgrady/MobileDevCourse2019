package servlet;

import bean.UserDetail;
import bean.UserInfo;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Hello World程序
 *
 * @author fangzhiyang
 */
@WebServlet("/hello2")
public class HelloWorldServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String studentId = req.getParameter("studentId");

        String comment = req.getParameter("comment");


        // TODO: 将学生返回的信息保存
//        resp.getWriter().print("success");

        // 拼装json代码
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setIdCard("123");

        UserDetail detail = new UserDetail();
        detail.setHeight("183");
        detail.setWidth("70");

        userInfo.setUserDetail(detail);

        System.out.println(detail.getClass().getPackage());
        System.out.println(detail.getClass().getPackage().getName());
        System.out.println(detail.getClass().getClassLoader());

        JSONObject jsonObject = new JSONObject(userInfo);


        resp.getWriter().print(jsonObject);

    }
}
