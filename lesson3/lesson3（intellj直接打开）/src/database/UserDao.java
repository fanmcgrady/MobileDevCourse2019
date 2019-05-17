package database;

import bean.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fangzhiyang
 */
public class UserDao {

    // 查询用户数据
    public static UserInfo getUserInfoById(String userId) {
        String sqlStr = "select id, name, id_card from t_user where id=" + userId;
        UserInfo userInfo = new UserInfo();

        try {
            Connection connection = DealData.getConn();
            PreparedStatement pstmt = connection.prepareStatement(sqlStr);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                userInfo.setName(rs.getString("name"));
                userInfo.setIdCard(rs.getString("id_card"));
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }

    // 列出所有用户
    public static List<UserInfo> listUser() {
        String sqlStr = "select id, name, id_card from t_user";
        List<UserInfo> userList = new ArrayList<>();

        try {
            Connection connection = DealData.getConn();
            PreparedStatement pstmt = connection.prepareStatement(sqlStr);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setName(rs.getString("name"));
                userInfo.setIdCard(rs.getString("id_card"));
                userList.add(userInfo);
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;
    }
}
