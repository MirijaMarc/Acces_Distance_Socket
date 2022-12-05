package affichage;
import java.awt.*;
import javax.swing.*;

import affichage.ClientPanel;


public class Fenetre extends JFrame {
    ClientPanel cpanel;


    public Fenetre(){
        setCpanel(new ClientPanel());
        setSize(getToolkit().getScreenSize());
        setVisible(true);
    }

    public void setCpanel(ClientPanel cpanel) {
        this.cpanel = cpanel;
    }

    public ClientPanel getCpanel() {
        return cpanel;
    }

    


}
