/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetest;

import java.sql.*;
/**
 *
 * @author zhangquan
 */
public class DatabaseTest {

    /**
     * @param args the command line arguments
     */
    
    //JDBC驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/stuInfo";
    
    //数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "AQYYADSDSW123zq";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Connection conn = null;
        Statement stmt = null;
        //注册JDBC驱动
        Class.forName("com.mysql.jdbc.Driver");
        
        //打开连接
        System.out.println("连接数据库...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        //执行查询
        System.out.println("实例化Statement对象");
        stmt = conn.createStatement();
        String sql;
        sql = "select * from student";
        ResultSet rs = stmt.executeQuery(sql);
        
        //展示结果集数据库
        while(rs.next()){
            //通过字段检索
           String Sno = rs.getString("Sno");
           String Sname = rs.getString("Sname");
           String Ssex = rs.getString("Ssex");
           String Sage = rs.getString("Sage");
           String Sdept = rs.getString("Sdept");
           
           //输出结果
           System.out.println("Sno:" + Sno);
           System.out.println("Sname:" + Sname);
           System.out.println("Ssex:" + Ssex);
           System.out.println("Sage:" + Sage);
           System.out.println("Sdept:" + Sdept);
        }
        
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Goodbye");
    }
    
}
