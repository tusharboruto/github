/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chattingapp.java;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author Administrator
 */
public class SendFile {
Socket s;
FileInputStream fis;
BufferedInputStream bis;
OutputStream os;
DataOutputStream dos1;
public void sendFile(String path){
     /*try{
        ss = new ServerSocket(1026);
        while(true){
        s = ss.accept();
        
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }*/
    try{
       dos1 = new DataOutputStream(User1.os);
         dos1.writeUTF(User1.filename);   
      File myFile = new File(path);
      byte[] mybytearray = new byte[(int)myFile.length()];
      fis = new FileInputStream(myFile);
      bis = new BufferedInputStream(fis);
      bis.read(mybytearray, 0, mybytearray.length);
    //  User1.os = s.getOutputStream();
     // javax.swing.JOptionPane.showMessageDialog(this,  path, "Sending....", JOptionPane.INFORMATION_MESSAGE, null);
     User1.os.write(mybytearray, 0, mybytearray.length);
      User1.os.flush();
      //lbl_path.setText("File Sent Successfully!!!!!");
      }catch(Exception fex){
          fex.printStackTrace();
      }finally{
          try{
          if(bis !=null) bis.close();
          if(User1.os !=null) User1.os.close();
          if(s !=null) s.close();
          }catch(Exception ex){
              
          }
}    
    
}
}
