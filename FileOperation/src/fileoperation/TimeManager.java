/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author zhangquan
 */
public class TimeManager implements Serializable{
    
    Calendar calendar;
    int year,month,day,hour,minute,second;
    String name;
    
    TimeManager(){
        calendar = Calendar.getInstance();
        
        //初始化为当前时间
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
    }
    
    //实现将当前时间写入文件夹
    public void outputCurrentTime(File f) throws FileNotFoundException, IOException{
//        char c[] = new char[20];
//        c = "          ";
//        Writer out = new FileWriter(f,true);
          OutputStream out = new FileOutputStream(f);
          String s = year + "年" + month + "月" + day + "日" + hour + "时" + second + "秒";
          byte[] b = s.getBytes();
          out.write(b);
          out.close();      
    }
    
    //实现获取文件上次记录时间，输出与当前时间的时间间隔
    public long getInternal(File f) throws FileNotFoundException, IOException, ParseException{
        long l;
        //FileInputStream in = new FileInputStream(f);
        FileReader inOne = new FileReader("1607030229.txt");
        BufferedReader inTwo =new BufferedReader(inOne);
        String strLine = inTwo.readLine();
        //String regex = "\\D+";
        //String digitWord[] = strLine.split(regex);
//        int y = Integer.parseInt(digitWord[0]);
//        int m = Integer.parseInt(digitWord[1]);
//        int d = Integer.parseInt(digitWord[2]);
//        int h = Integer.parseInt(digitWord[3]);
//        int min = Integer.parseInt(digitWord[4]);
//        int s = Integer.parseInt(digitWord[5]);
        Calendar cal;
        cal = Calendar.getInstance();
        //cal.set(y, m,d,h,min,s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        Date d =sdf.parse(strLine);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d);
        l = cal.getTimeInMillis()-cal2.getTimeInMillis();       
        inOne.close();
        return l;
    }
    
    public void insert(File f,int p,String s) throws FileNotFoundException, IOException{
        //利用随机流在文件f的位置p处插入字符串
        RandomAccessFile inAndOut = null;
        inAndOut = new RandomAccessFile(f,"rw");
        inAndOut.seek(p);
        inAndOut.writeBytes(s);
    }
    
    //设置name变量的值
    public void setName(String s){
        name = s;
    }
    
    //获取name名
    public String getName(){
        return name;
    }
    
}
