package com.study.lion.lesson.aboutNio;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try (Socket client = new Socket(InetAddress.getLocalHost(), 8000);) {
                while (true) {
                    client.getOutputStream().write((new Date() + ":hello world").getBytes());
                    client.getOutputStream().flush();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }).start();

    }
}
