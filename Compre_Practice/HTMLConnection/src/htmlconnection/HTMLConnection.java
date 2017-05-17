package htmlconnection;
import java.io.*;
import java.net.*;
public class HTMLConnection {
    public static void main(String[] args) throws Exception{
        URL newUrl = new URL("");
        URLConnection connection = newUrl.openConnection();
        connection.connect();
        String outputFile = "E:\\Notes\\III YEAR\\Sem II\\Computer Networks\\LabPrograms\\HTMLConnection\\file.jpg";
       // String outputFile = "E:\\Notes\\III YEAR\\Sem II\\Computer Networks\\LabPrograms\\HTMLConnection\\file.html";
        
       // Start for JPG image download
       InputStream newInputStream = connection.getInputStream();
       byte[] data = new byte[100];
       int count;
       FileOutputStream newFileOutputStream = new FileOutputStream(outputFile,true);       
       while((count = newInputStream.read(data)) != -1)
       {
           newFileOutputStream.write(data,0,count);
       }
       // End for JPG image download
       
       //Start for HTML content download
//       BufferedReader fromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//       FileWriter outputFile = new FileWriter(outputFile,true);
//       String html;
//       while(html = fromServer.readLine()) != null)
//       {
//           outputFile.write(html);
//           outputFile.write("\n");
//       }
       //End for HTML content download
       
       newFileOutputStream.flush();
       newFileOutputStream.close();
//       outputFile.flush();
//       outputFile.close
        
    }    
}
