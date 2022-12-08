package affichage;

import java.net.*;
import java.util.Vector;

import moteur.*;

import java.io.*;
import java.util.*;


public class ServeurMain{
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (Exception e)
         { System.err.println(e); }
        }

}