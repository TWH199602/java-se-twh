package 购物街原型.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String loginName = "bbb";
        String userName = "bbb";
        String password = "123456";
        int sex = 0;
        String identityCode = null;
        String email = "948692859@qq.com";
        String mobile = "13339999865";
        int type = 1;
        String sql = "insert into user(loginName,userName,password,sex,identityCode,email,mobile,type) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, loginName);
        pstm.setString(2, userName);
        pstm.setString(3, password);
        pstm.setInt(4, sex);
        pstm.setString(5, identityCode);
        pstm.setString(6, email);
        pstm.setString(7, mobile);
        pstm.setInt(8, type);
        JdbcUtils.closeConnection(conn, pstm);
        //`id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
//            `name` varchar(20) NOT NULL COMMENT '名称',
//            `description` varchar(1024) DEFAULT NULL COMMENT '描述',
//            `price` float NOT NULL COMMENT '价格',
//            `stock` int(10) NOT NULL COMMENT '库存',
//            `categoryLevel1Id` int(10) DEFAULT NULL COMMENT '分类1',
//            `categoryLevel2Id` int(10) DEFAULT NULL COMMENT '分类2',
//            `categoryLevel3Id` int(10) DEFAULT NULL COMMENT '分类3',
//            `fileName` varchar(200) DEFAULT NULL COMMENT '文件名称',
//            `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1：删除 0：未删除)'
//        String sql4 = "insert int product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,filename,isDelete) values(?,?,?,?,?,?,?,?,?)";
//        PreparedStatement pstm4 = conn.prepareStatement(sql4);
//        pstm4.setString(1,name);
    }

    public static List<Users> getUsersList() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        conn = JdbcUtils.getConnection();
        String sql2 = "select * from user";
        PreparedStatement pstm2 = conn.prepareStatement(sql2);
        ResultSet rs = pstm2.executeQuery();

        List<Users> usersList = new ArrayList<>();
        while (rs.next()) {
            Users users = new Users();
            users.setId(rs.getInt(1));
            users.setLoginName(rs.getString(2));
            users.setUserName(rs.getString(3));
            users.setPassword(rs.getString(4));
            users.setSex(rs.getInt(5));
            users.setIdentityCode(rs.getString(6));
            users.setEmail(rs.getString(7));
            users.setMobile(rs.getString(8));
            users.setType(rs.getInt(9));
            usersList.add(users);
        }
        return usersList;
    }

    public static boolean isLogin() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String loginName = "aaa";
        String password = "123456";
        String sql3 = "select * from user where loginName = ? and password = ?";
        PreparedStatement pstm3 = conn.prepareStatement(sql3);
        pstm3.setString(1,"aaa");
        pstm3.setString(2,"123456");
        List<Users> usersList = getUsersList();
        for (Users users : usersList) {
            if (users.getLoginName().equals(loginName) && users.getPassword().equals(password)) {
                System.out.println("登陆成功！");
                  return true;
              }
          }
        System.out.println("登陆失败！");
           return false;
        }

    
    }

