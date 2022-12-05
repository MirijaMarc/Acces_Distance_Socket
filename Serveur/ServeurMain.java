package affichage;

import java.net.*;
import java.util.Vector;

import moteur.Moteur;

import java.io.*;
import java.util.*;


public class ServeurMain{


    public void run(){
        System.out.println("bonjour");
    }
    public static void main(String[] args) {
        try {
            Vector v = new Vector();
            ServerSocket listenSocket = new ServerSocket(4567); // port
            Moteur thread = new Moteur(listenSocket);
            while (true) {
                thread.run();
            }
            
            // while(true) {
            // Socket clientSocket = listenSocket.accept();
            // System.out.println(clientSocket.getInetAddress());
            // ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            // System.out.println(ois.readObject().toString());
            // }
        } catch (Exception e)
         { System.err.println(e); }
        }

}