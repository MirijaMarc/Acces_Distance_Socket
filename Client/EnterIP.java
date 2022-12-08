package affichage;

import java.net.Socket;

import javax.swing.*;


public class EnterIP {
    JFrame fenetre;
    Socket socket;
    String ip;
    static int port=4567;


    public EnterIP(){
        fenetre=new JFrame();
        fenetre.setSize(200,200);
        fenetre.setVisible(false);
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        InitializeIP();
    }

    public void InitializeIP(){
        ip = JOptionPane.showInputDialog(fenetre,"Enter a IP");
        try {
            socket = new Socket(ip,port);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fenetre.dispose();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    public String getIp() {
        return ip;
    }

    public JFrame getFenetre() {
        return fenetre;
    }
    public static int getPort() {
        return port;
    }
    public void setFenetre(JFrame fenetre) {
        this.fenetre = fenetre;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public static void setPort(int port) {
        EnterIP.port = port;
    }

}
