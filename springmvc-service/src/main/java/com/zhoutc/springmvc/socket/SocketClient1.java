package com.zhoutc.springmvc.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by zhoutc on 2016-11-01.
 */
public class SocketClient1 {
    public static void main(String[] args)  {
        try{
            Socket mysocket = new Socket("localhost",19999);
            OutputStream outputStream = mysocket.getOutputStream();
            InputStream inputStream = mysocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            while (true){
                dataOutputStream.writeBytes("i am sunqi\n");
                dataOutputStream.flush();
                System.out.println("发送消息成功");
                Thread.sleep(500);
            }
        }catch (Exception e){

            e.printStackTrace();
        }


    }
}
