package Sample4;
import java.net.*; 
import java.io.*; 
public class MultiThreadServer implements Runnable{
    
    Socket perClientSocket;

    public MultiThreadServer(Socket connectionSocket) {
        perClientSocket = connectionSocket;
    }
       
    @Override
    public void run(){
        // Things to do in this method:-
        // 1) Attach input stream and output stream to perClientSocket.
        // 2) Wait for info from client. 
        // 3) Once info is received, convert all lower case letters into uppercase.
        while(true){
            try {
                BufferedReader inputStreamBufferedReader = new BufferedReader(new InputStreamReader(perClientSocket.getInputStream()));
                PrintWriter outputClient = new PrintWriter(perClientSocket.getOutputStream());

                String inputString = inputStreamBufferedReader.readLine();  // Read from BufferedReader
                String outputString = inputString.toUpperCase();            // Convert text to uppercase to re-send

                outputClient.print(outputString);                          // Write into PrintWriter
                outputClient.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true){
            // We need to have a while loop here to create a Socket object for each Thread of the MultiThreadServer object
            
            Socket connectionSocket = welcomeSocket.accept();

            // Server waits for connection from client.
            // Server should start a thread to serve any client.

            MultiThreadServer multiThreadServer = new MultiThreadServer(connectionSocket);
            Thread perClientThread = new Thread(multiThreadServer);
            perClientThread.start();
        }
    }
}
