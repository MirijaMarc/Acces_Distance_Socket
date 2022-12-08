package affichage;
import event.*;
import java.awt.*;
import javax.swing.*;
import moteur.*;


import java.awt.Color;

public class ClientMain {
    public static void main(String[] args) {
        try {
            EnterIP enter = new EnterIP();
            Client c = new Client(enter.getSocket());
            c.start();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}