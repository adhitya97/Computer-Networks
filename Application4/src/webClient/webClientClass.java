
package webClient;

import java.net.*;
import java.io.*;

public class webClientClass {
    public static void main(String[] args) throws Exception{
        String html;
        URL urlobject = new URL("http://www.bits-pilani.ac.in/Uploads/Campus/BITS_Dubai_campus_logo.gif");
        // URL urlobject = new URL("https://lh3.googleusercontent.com/nYhPnY2I-e9rpqnid9u9aAODz4C04OycEGxqHG5vxFnA35OGmLMrrUmhM9eaHKJ7liB-=w300");
        URLConnection connection = urlobject.openConnection();
        connection.connect();
        // Once we open the connection to a URL objectbeneath it, a client socket gets connected to the server
        // and sends all the HTTP request headers derived from the URL and are sent via the socket
        // Also HTTP response headers are got
        
        InputStream fromserver = connection.getInputStream();
        byte[] data = new byte[100];
        int count;
        
        String filenameString = "C:\\Users\\admin\\Desktop\\035\\JavaApplication5\\tester.gif";
        //String filenameString = "C:\\Users\\admin\\Desktop\\035\\JavaApplication5\\tester.jpg";
        
        FileOutputStream outputStream = new FileOutputStream(filenameString,true);
        
        while((count = fromserver.read(data)) != -1)
        {
            outputStream.write(data,0,count);
        }
        outputStream.flush();
        outputStream.close();
    }
}
