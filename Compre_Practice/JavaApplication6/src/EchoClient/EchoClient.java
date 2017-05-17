package EchoClient;
import java.net.*;
import java.io.*;
public class EchoClient {
    public static void main(String[] args) throws Exception{
        String hostName = new String("127.0.0.1");
        Socket echoSocket = new Socket(hostName,6789);
        PrintWriter outputStream = new PrintWriter(echoSocket.getOutputStream());
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdInputStream = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Input: ");
        while ((userInput = stdInputStream.readLine()) != null) {            
            outputStream.print(userInput);
            System.out.println("Echo: "+userInput);
            System.out.println("Input: ");
        }
        inputStream.close();
        outputStream.close();
        echoSocket.close();
        stdInputStream.close();
    }
}
