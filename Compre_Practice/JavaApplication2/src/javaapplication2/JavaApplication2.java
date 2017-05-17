package javaapplication2;
import java.io.*;
import java.net.*;

public class JavaApplication2 {

    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket clientSocket = welcomeSocket.accept();
        
        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String input = inputFromClient.readLine();
        String output = input.toUpperCase();
        PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream());
        outputWriter.println(output);
        outputWriter.flush();
        
    }
    
}
