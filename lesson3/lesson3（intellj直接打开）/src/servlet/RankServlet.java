package servlet;

import bean.Rank;
import bean.RankData;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangzhiyang
 */
@WebServlet("/getList")
public class RankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rank rank = new Rank();
        rank.setStatusCode(200);

        List<RankData> list=new LinkedList<>();
        
        RankData rankData = new RankData();
        rankData.setName("1111");
        rankData.setScore(1);
        list.add(rankData);

        rankData = new RankData();
        rankData.setName("2222");
        rankData.setScore(2);
        list.add(rankData);
        
        rank.setData(list);

        JSONObject result = new JSONObject(rank);

        // 返回结果
        resp.getWriter().print(result);
    }
}
