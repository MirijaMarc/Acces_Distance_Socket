package moteur;

import affichage.*;
import java.io.*;
import java.net.*;
import java.util.Vector;
import javax.imageio.*;
import java.awt.image.*;

public class Moteur extends Thread{
    ServerSocket servSock;
    Vector clients;
    Fenetre mywindow;

    public Moteur(ServerSocket sc){
        setClients(new Vector());
        setServSock(sc);
        this.start();
    }

    public Fenetre getMywindow() {
        return mywindow;
    }

    public void setMywindow(Fenetre mywindow) {
        this.mywindow = mywindow;
    }

    public Vector getClients() {
        return clients;
    }

    public void setClients(Vector clients) {
        this.clients = clients;
    }

    public ServerSocket getServSock() {
        return servSock;
    }
    public void setServSock(ServerSocket servSock) {
        this.servSock = servSock;
    }
    
    public void run(){
        try {
            Socket clientSocket = servSock.accept();
            InputStream ois =clientSocket.getInputStream();
            setMywindow(new Fenetre());
            getMywindow().setCpanel(new ClientPanel());
             while(true) {
                if (!clients.contains(clientSocket)){
                    clients.add(clientSocket);
                    System.out.println(clientSocket);
                }
                
                byte[] bytes = new byte[1024* 1024];
                int count = 0;
                do {
                count += ois.read(bytes, count, bytes.length-count);
                } while ( !(count > 4 && bytes[count - 2] == (byte) -1 && bytes[count - 1] == (byte) -39));

                BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
                //  byte[] b = new byte[ois.available()];
                //  System.out.println(image);
                //  ois.read(b);
                //  = ImageIO.read(ois);
              // System.out.println(ois.available());
                
                //  getMywindow().setCpanel(new ClientPanel(image));
                getMywindow().getCpanel().setImg(image);
                // System.out.println(getMywindow().getCpanel().getImg()+"image");
                // // getMywindow().add(getMywindow().getCpanel());

                // Thread.sleep(100);
                // // getMywindow().dispose();
                //System.out.println(ois.available());
                getMywindow().getCpanel().repaint();
                getMywindow().add(getMywindow().getCpanel());

                Thread.sleep(1);
            
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}