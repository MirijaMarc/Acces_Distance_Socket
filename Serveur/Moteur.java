package moteur;

import event.*;
import affichage.*;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Vector;
import javax.imageio.*;
import java.awt.*;

import java.awt.Image;
import java.awt.image.*;

public class Moteur extends Thread implements Runnable{
    Socket clientSock;
    Vector clients;
    Fenetre mywindow;
    boolean running= true;
    int tickCount=0;

    public Moteur(Socket sc){
        setClients(new Vector());
        clientSock=sc;
        
        // this.start();
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


    public void run() {
        try {
            setMywindow(new Fenetre(clientSock));
            InputStream ois =clientSock.getInputStream();
            DataInputStream in = new DataInputStream(ois);
            Vector<Byte> v = new Vector<>();
            
        while (true) {
            byte[] sizeAr = new byte[4];
            in.readFully(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
            byte[] bytes = new byte[size];
            int totalRead=0;
            int currentRead;
            while(totalRead<size && (currentRead = in.read(bytes,totalRead,size-totalRead))>0){
                totalRead+=currentRead;
            }
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            //  System.out.println(image);
            getMywindow().setImg(image);
            getMywindow().setSize(image.getWidth(),image.getHeight()+30);
            getMywindow().update();   
            Thread.sleep(4);     
        
        }
    }catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    
   
}