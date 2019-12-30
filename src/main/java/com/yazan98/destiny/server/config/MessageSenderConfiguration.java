package com.yazan98.destiny.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:53 PM
 */

public class MessageSenderConfiguration {

    public void sendSms(String senderContent , String content , String reciver) {
        try {
            // Construct data
            String apiKey = "apikey=" + "P0lP+Xh/XQE-sRjObTuFH6k5xwJ7BQlDm5xxC7LOsB";
            String message = "&message=" + content;
            String sender = "&sender=" + senderContent;
            String numbers = "&numbers=" + reciver;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuilder stringBuffer = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

        } catch (Exception e) {
            System.out.println("Error SMS "+e);
        }
    }

}
