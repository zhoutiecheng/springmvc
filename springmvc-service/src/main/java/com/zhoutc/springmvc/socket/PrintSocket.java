package com.zhoutc.springmvc.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by zhoutc on 2016-11-01.
 */
public class PrintSocket implements Runnable {
    private Socket socket;

    public PrintSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while (true) {
                String info = br.readLine();
                System.out.println("我是服务器，客户端说：" + info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}