package EchoServer;
import java.net.*;
import java.io.*;
public class EchoServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6789);
        Socket socket = serverSocket.accept();
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream outputStream = new PrintStream(socket.getOutputStream(),true);
        
        String input;
        while ((input = inputStream.readLine()) != null) {            
            System.out.println("Server: "+ input);
            outputStream.print(input);
            if(input.equals("bye"))
            {
                break;
            }
        }
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        socket.close();
    }
}
