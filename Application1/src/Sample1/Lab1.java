package Sample1;

import java.net.*;
import java.io.*;

public class Lab1 {
    public static void main(String[] args) throws Exception{
        // Create a ServerSocket via port numbr 6789
        // Wait for connctions from client
        // The server applicaion will be assigned the address of 6789 
        ServerSocket serverSocket = new ServerSocket(6789);
        
        // Listen for connection from the client
        
        Socket clientSocket = serverSocket.accept();
        
        // clientsocket is used for further communication between server and client
        // Sockets being byte-oriented devices, should be atached to input stream and output stream.
        
        BufferedReader inputFromClientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter outputClient = new PrintWriter(clientSocket.getOutputStream());
        
        String inputString = inputFromClientReader.readLine();  // Read from BufferedReader
        String outputString = inputString.toUpperCase();        // Convert text to uppercase to re-send
        
        outputClient.print(outputString);                       // Write into PrintWriter
        outputClient.flush();
        
    }
}
