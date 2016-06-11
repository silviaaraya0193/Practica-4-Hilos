/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.File_Reader;
import Modelo.Lock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silvia Araya J
 */
public class Printer_Results implements Runnable {

    private File_Reader reader;
    private List<Thread> threadList;
    private String name;
    private Thread hilo;
    private int numeroLinea;
    private ManejoEstadistica managerEstadistic;
    private Lock lock;

    public Printer_Results(File_Reader reader, String name,Lock lock) {
        this.reader = reader;
        this.name = name;
        threadList = new ArrayList<Thread>();
        numeroLinea = 0;
        this.lock = lock;
        managerEstadistic = new ManejoEstadistica();
    }

    @Override
    public void run() {
        String valores = " ";
        String[] padron;
        valores = (String) reader.next();
        while (reader.hasNext() && valores != null) {
            try {
                for (int i = 0; i < 1000 && reader.hasNext() && valores != null; i++) {
                    lock.lock();
                   // System.out.println("***" + valores);
                    if (!valores.equals("")) {
                        padron = valores.split(",");
                    //    System.out.println("Se envia: "+padron[0]+"  "+padron[1]+" "+padron[2]);
                        managerEstadistic.addToList(padron[0], padron[1],padron[1]);
                       // managerEstadistic.addCantidadCanton(padron[0], padron[2]);
                    }

                    valores = (String) reader.next();
                    lock.unlock();
                }
            } catch (InterruptedException ex) {
                System.out.println("System error");
            } catch (NullPointerException ex) {
                System.out.println("System con null");
            }
        }
        
        managerEstadistic.lookHash();

//        Object info = reader.next();
//        while (reader.hasNext() && info != null) {
//
////            System.out.println("Linea: " + numeroLinea + ": "
////                    + threadList + "" + info.toString());
//            
//            managerEstadistic.addToList(info.toString());
//
//            info = reader.next();
//            numeroLinea++;
//        }
//        managerEstadistic.getInfoArray();
    }

    public void start() {
        for (int index = 0; index < 2; index++) {
            hilo = new Thread(this, name + index);
            hilo.start();
            threadList.add(hilo);
        }
    }

    public void join() {
        for (int index = 0; index < threadList.size(); index++) {
            try {
                threadList.get(index).join();
            } catch (InterruptedException e) {
                Logger.getLogger(Printer_Results.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}
