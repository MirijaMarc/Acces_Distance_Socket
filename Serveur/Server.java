package moteur;
import java.net.*;

public class Server extends Thread {
    
    public Server(){}

    public void run(){
        try {
            ServerSocket listenSocket = new ServerSocket(4567);
            while (true){
                Socket clientSock = listenSocket.accept();
                Moteur moteur = new Moteur(clientSock);
                moteur.start(); 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
