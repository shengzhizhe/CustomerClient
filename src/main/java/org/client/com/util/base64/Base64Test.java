package org.client.com.util.base64;

import org.springframework.util.Base64Utils;

public class Base64Test {

    public static void main(String[] args) {
        try {

            byte[] bytes = Base64Utils.decode("MTIzNDU2Nzhh".getBytes("UTF-8"));
            System.out.println(new String(bytes, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
