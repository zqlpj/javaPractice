/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datawork;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author zhangquan
 */
public class DataWork {

    /**
     * @param args the command line arguments
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/stuInfo?useUnicode=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "AQYYADSDSW123zq";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Connection conn = null;
        PreparedStatement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        Operation data = new Operation();
        //data.Insert(conn,stmt);   
//        data.Search(conn, stmt);
        data.Del(conn, stmt);
    }
}
