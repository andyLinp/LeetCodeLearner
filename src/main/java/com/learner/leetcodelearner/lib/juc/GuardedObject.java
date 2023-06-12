package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 同步模式之保护性暂停
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
@Slf4j(topic = "c.GuardedObject")
public class GuardedObject {

    private Object response;
    private final Object lock = new Object();

    public Object get() {
        synchronized (lock) {
            // wait for not meet the conditions
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return  response;
    }



    public void complete(Object response) {
        synchronized (lock) {
            // meet conditions notify all
            this.response = response;
            lock.notifyAll();
        }
    }


    // test
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            try {
                List<String> response = download();
                log.debug("download complete...");
                guardedObject.complete(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        log.debug("waiting...");
        // main thread waiting
        Object response = guardedObject.get();
        log.debug("get response:[{}] lines", ((List<String>)response).size());
    }


    public static List<String> download() throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL("https://www.baidu.com/").openConnection();
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
