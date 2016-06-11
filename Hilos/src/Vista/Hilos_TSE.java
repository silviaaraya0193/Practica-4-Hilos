/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Printer_Results;
import Modelo.File_Reader;
import Modelo.Lock;

/**
 *
 * @author Silvia Araya J
 */
public class Hilos_TSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File_Reader reader= new File_Reader("Distelec.txt");
        Lock lock = new Lock();
        Printer_Results printer= new Printer_Results(reader, "Hilo #",lock);
        printer.start();
        printer.join();
    }
    
}
