package 购物街原型.java;

import java.sql.*;

public class jdbcUtil {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // jdbc driver class name
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        // 数据库字符串
        String url = "jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "12345678";
        // 加载驱动类
        Class.forName(jdbcDriver);
        // 创建数据库连接
        Connection conn = DriverManager.getConnection(url,username,password);
        // 创建statement对象，用于执行sql语句；
        Statement stmt = conn.createStatement();
        String sql = "SELECT * from student";
//ResultSet 看成指针（游标），指向查询结果集第一行的上面；
        //
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            boolean sex = rs.getBoolean(3);
            Date birthday = rs.getDate(4);

            System.out.println(id+"\t" + name+"\t" + sex + "\t" + birthday);
        }

//        "create table student(\n" +
//                "\tid int primary key auto_increment,\n" +
//                "    name varchar(20),\n" +
//                "    gender boolean,\n" +
//                "    birthday date\n" +
//                ");";


        //        执行executeXXX()执行sql
//            如果是非查询sql executeUpdateZ()
//            如果是查询sql executeQuery()
//        stmt.executeUpdate(sql);
        rs.close();
        stmt.close();
        conn.close();
    }
}
