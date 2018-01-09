package ssy.network;

import java.net.URL;

public class URL1 {


    public static void main(String[] args) throws  Exception{

        URL url = new URL("https://www.miaoqian.com");

        String protocal = url.getProtocol();
        String host = url.getHost();
        String file = url.getFile();
        int port = url.getPort();
        String ref = url.getRef();

        System.out.println("protocal: "+protocal);
        System.out.println("host: "+host);
        System.out.println("file: "+file);
        System.out.println("port: "+port);
        System.out.println("ref: "+ref);


    }
}
