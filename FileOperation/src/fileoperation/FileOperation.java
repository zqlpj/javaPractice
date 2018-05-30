/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author zhangquan
 */
public class FileOperation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        File file = new File("1607030229.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        TimeManager time = new TimeManager();
        time.outputCurrentTime(file);
        TimeManager t = new TimeManager();
        t.setName("苏芮");
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(t);
        objectOut.close();
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        //objectIn.readObject();
        TimeManager t2 = (TimeManager)objectIn.readObject();
        objectIn.close();
        System.out.println(t2.getName());
    }
    
}
