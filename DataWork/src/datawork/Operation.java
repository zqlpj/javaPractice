/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datawork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author zhangquan
 */
public class Operation {
    
    public void Insert(Connection conn) throws SQLException{
        //插入学生信息
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入插入的学生信息");
        System.out.println("学号：");
        String Sno = sc.next();
        System.out.println("姓名：");
        String Sname = sc.next();
        System.out.println("性别：");
        String Ssex = sc.next();
        while(isSex(Ssex)){
            System.out.println("您输入的信息有误，请重试");
            Ssex = sc.next();
        }
        System.out.println("年龄：");
        String Sage = sc.next();
        int age = Integer.parseInt(Sage);
        while(!isAge(age)){
            System.out.println("年龄必须在15——45岁之间，请重新输入");
            Sage = sc.next();
            age = Integer.parseInt(Sage);
        }
        System.out.println("所在系：");
        String Sdept = sc.next();
        String sql;
        sql = "insert into student values (" + "'" + Sno + "'" + "," + "'" + Sname + "'" 
                + "," +  "'" + Ssex + "'" + "," + age + "," + "'" + Sdept + "'" + ")";
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        //conn.close();
    }
    
    
    //按学号查询学生信息
    public void Search(Connection conn) throws SQLException{
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询的学号");
        String Sno = sc.next();
        String sql;
        sql = "select * from student where Sno = '" + Sno + "'" ;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            System.out.println(rs.getString("Sno") + "  " + rs.getString("Sname")
             + "  " + rs.getString("Ssex") + "  " + rs.getString("Sage") + "  " +
                    rs.getString("Sdept"));
        }
        else{
            System.out.println("没有该学生信息");
        }
        rs.close();
        stmt.close();
        //conn.close();
    }
    
    //按学号删除学生信息
    
    public void Del(Connection conn) throws SQLException{
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号");
        String Sno = sc.next();
        if(isValue(conn,stmt,Sno)) {
            String sql;
            sql = "delete from student where Sno = '" + Sno + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            int i = stmt.executeUpdate(sql);
            //java中int型是不能转化为boolean的
            if (i != 0) {
                System.out.println("删除成功");
            }
        }
        else{
            System.out.println("对不起，没有该学生信息！！！");
        }
        stmt.close();
        //conn.close();
    }

    //按学号修改学生信息
    public void Update(Connection conn){
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生信息");
        System.out.println("请输入学生的学号：");
        String Sno = sc.next();
        System.out.println("请输入学生的姓名：");
        String Sname = sc.next();
        System.out.println("请输入学生的性别：");
        String Ssex = sc.next();
        while(isSex(Ssex)){
            System.out.println("您输入的信息有误，请重试");
            Ssex = sc.next();
        }
        System.out.println("请输入学生的年龄：");
        int Sage = sc.nextInt();
        while(!isAge(Sage)){
            System.out.println("年龄必须在15——45岁之间，请重新输入");
            Sage = sc.nextInt();
            //age = Integer.parseInt(Sage);
        }
        System.out.println("请输入学生的所在系：");
        String Sdept = sc.next();
//        System.out.println("请输入要修改的学生信息");
        if(isValue(conn,stmt,Sno)) {
            String sql;
            sql = "UPDATE student set Sno = '" + Sno + "'" + "," + "Sname='" + Sname + "'"
                    + "," +  "Ssex = '" + Ssex + "'" + "," + "Sage = " + Sage + "," + "Sdept = '" + Sdept + "'" +
                    "where Sno = " + "'" + Sno + "'" + ";";
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
       //     stmt.close();
//            conn.close();


        }
    }

    //判断是否有该学生
    public boolean isValue(Connection conn,Statement stmt,String Sno){
        String sql;
        sql = "select * from student where Sno = '" + Sno + "'";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //判断学生年龄是否在15-45之间
    public boolean isAge(int age){
        if(age>=15&&age<=45){
            return true;
        }
        return false;
    }

    //判断学生性别是否符合要求
    public boolean isSex(String sex){
        if(sex.equals('男') || sex.equals('女')){
            return true;
        }
        return false;
    }
}
