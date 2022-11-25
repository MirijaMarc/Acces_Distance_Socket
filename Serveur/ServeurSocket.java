package affichage;

import java.net.*;
import java.io.*;

public class ServeurSocket {
    public static void main(String[] args) {
        try {
            ServerSocket listenSocket = new ServerSocket(4567); // port
            Socket clientSocket = listenSocket.accept();
            while(true) {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println(ois.readObject().toString());
            }
        } catch (Exception e)
         { System.err.println(e); }
        }

}
