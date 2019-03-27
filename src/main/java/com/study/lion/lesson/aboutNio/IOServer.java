package com.study.lion.lesson.aboutNio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {

            //创建一个线程,用于接收新连接
            new Thread(() -> {
                while (true) {
                    try (Socket accept = server.accept()) {//获取新的连接（阻塞方式）
                        //每一个新的连接都创建一个线程，负责读取数据
                        new Thread(() -> {
                            try {
                                byte[] data = new byte[1024];
                                InputStream inputStream = accept.getInputStream();
                                while (true) {
                                    int len;
                                    // (3) 按字节流方式读取数据
                                    while ((len = inputStream.read(data)) != -1) {
                                        System.out.println(new String(data, 0, len));
                                    }
                                }
                            } catch (IOException e) {
                            }
                        }).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
