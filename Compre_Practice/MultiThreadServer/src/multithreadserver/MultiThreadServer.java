package multithreadserver;
import java.net.*;
import java.io.*;
public class MultiThreadServer implements Runnable{
    Socket perClientSocket;
    public MultiThreadServer(Socket connectionSocket)
    {
        perClientSocket = connectionSocket;
    }
    @Override
    public void run()
    {
        while (true) {
            try {
                BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(perClientSocket.getInputStream()));
            String input = inputBufferedReader.readLine();
            String output = input.toUpperCase();
            PrintWriter outPrintWriter = new PrintWriter(perClientSocket.getOutputStream());
            outPrintWriter.print(output);
            outPrintWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
    }
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            MultiThreadServer newMultiThreadServer = new MultiThreadServer(connectionSocket);
            Thread perClientThread = new Thread(newMultiThreadServer);
            perClientThread.start();
        }
    }
    
}
