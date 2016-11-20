package com.zhoutc.springmvc.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhoutc on 2016-11-01.
 */
public class SocketServer {

    public static void main(String[] args) {
        try {
            //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(19999);
            //2、调用accept()方法开始监听，等待客户端的连接
            // Socket socket = serverSocket.accept();
            //3、获取输入流，并读取客户端信息
           /* InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);*/
            //DataInputStream in = new DataInputStream(socket.getInputStream());
            //DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String info = null;
            while (true) {
                Socket socket = serverSocket.accept();
                PrintSocket printSocket = new PrintSocket(socket);
                new Thread(printSocket).start();
                //System.out.println("我是服务器，客户端说：" + info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
