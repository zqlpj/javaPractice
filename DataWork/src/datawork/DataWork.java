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
        //Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        Operation data = new Operation();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int choice;
        while(flag) {
            System.out.println("~~~~~~~~~~~~~~欢迎使用本系统，请选择服务！！！！！~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~1、按学号查询学生信息~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~2、按学号删除学生信息~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~3、按学号修改学生信息~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~4、插入学生信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~5、退出系统~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    data.Search(conn);
                    break;
                case 2:
                    data.Del(conn);
                    break;
                case 3:
                    data.Update(conn);
                    break;
                case 4:
                    data.Insert(conn);
                    break;
                case 5:
                    flag = false;
            }
        }
        conn.close();
        System.out.println("再见！！！");
    }
}
