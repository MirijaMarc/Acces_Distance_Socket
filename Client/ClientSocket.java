package affichage;

import java.net.*;
import java.io.*;


public class ClientSocket {
    public static void main(String[] args) {
       
        try {
            //System.out.println(InetAddress.getByName("0.0.0.0/0.0.0.0"));
            Socket theSocket = new Socket("192.168.43.157",1899);
            
            
                String theLine ="";
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                theLine = input.readLine();
                ObjectOutputStream ois = new ObjectOutputStream(theSocket.getOutputStream());
                ois.writeObject(theLine);
                // ois.close();
                if (theLine.equals(".")){
                    break;
                } 
                //System.out.println(theInputStream.readLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }    
}
