package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DealData {

    // 获取数据库连接
    public static Connection getConn() {
        Connection connection = null;
        try {
            // 数据库用户名
            String userName = "root";
            // 密码
            String userPasswd = "1234";
            // 数据库名 characterEncoding=utf-8
            String url = "jdbc:mysql://localhost:3306/lesson5";
            // 数据库用户名
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, userName, userPasswd);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return connection;
    }

    public static void getData() {
        // 姓名	身份证号码	体检卫生院	性别	年龄	住址	联系电话
        String sqlStr = "select id, name from t_user";
        try {
            Connection connection = getConn();
            PreparedStatement pstmt = connection.prepareStatement(sqlStr);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // =====================
    public static void main(String[] args) {
        getData();
    }
}
