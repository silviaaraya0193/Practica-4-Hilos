/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Canton;
import Modelo.Personas;
import Modelo.Provincia;

import java.util.HashMap;

import java.util.Map;

/**
 *
 * @author Silvia Araya J
 */
public class ManejoEstadistica {

    private Map<String, Provincia> provinciasList;
    private Map<String,Canton> cantonList; 
    private Map<String,Personas> hombreList;
    private Map<String,Personas>mujerList;
    
    private Map<String,Provincia> hashTry;

    public ManejoEstadistica() {
        //provinciasList = new ArrayList<Estadistica>();
        provinciasList = new HashMap<String, Provincia>();
        cantonList= new HashMap<String,Canton>();
       
    }

    public void addToList(String codElect,String provincia,String canton) {
        provinciasList.put(codElect,new Provincia(codElect, provincia));
        cantonList.put(codElect,new Canton(codElect,canton)); 
    }
    
    
    public void addGeneros(String codElect,String genero){
        switch(genero){
            case "1":/*hombres*/
                if(hombreList.containsKey(codElect)){
                    Personas sujeto=hombreList.get(codElect);
                    sujeto.setCantidad(sujeto.getCantidad()+1);
                    hombreList.replace(codElect, sujeto);
                }else{
                    hombreList.put(codElect, new Personas(codElect, 1) );
                }
                break;
            case "2":/*mujeres*/
                if(mujerList.containsKey(codElect)){
                    Personas sujeto=mujerList.get(codElect);
                    sujeto.setCantidad(sujeto.getCantidad()+1);
                    mujerList.replace(codElect, sujeto);
                }else{
                    mujerList.put(codElect, new Personas(codElect, 1) );
                }
                break;
    }
    }
    
    /*-------------intento de autoIncrementar el asunto------------------------------*/
    /* para este caso en especifico, el numero no aumentara ya que el codigo obtetinido es 
    unico en todo el archivo, una vez que se pruebe con personas, cambiara*/
    public void addCantidadCanton(String codElect,String canton){
        if(hashTry.containsKey(codElect)){
            Provincia provincia= hashTry.get(codElect);
            provincia.setCantidad(provincia.getCantidad()+1);
           // hashTry.put(codElect, );
           hashTry.put(codElect, provincia);
//            System.out.println("La Contiene la carajada: "+
//                    provincia.getProvincia()+" Cantidad cantones:"+provincia.getCantidad());
        }
    }
    public void lookHash(){
        for(Map.Entry entry:hashTry.entrySet()){
            String key= (String) entry.getKey();
            Provincia valor= (Provincia)entry.getValue();
            System.out.println("Clave: "+key+"  Provincia: "+valor.getProvincia());
        }
        
    }
//    public void getInfoArray() {
//        for (int index = 0; index < provinciasList.size(); index++) {
//            if (provinciasList.get(index) != null) {
//                System.out.println("Arreglo:  " + provinciasList.get(index).getInfo());
//            }
//
//        }
//        getEstadistics();
//    }

//    public void getEstadistics() {
//        int sj = 0, al = 0, lm = 0, ptn = 0, gt = 0, ctg = 0, hd = 0, cns = 0;
//
//        for (int index = 0; index < provinciasList.size(); index++) {
//            if (provinciasList.get(index) != null) {
//
//                switch (provinciasList.get(index).getProvincia()) {
//                    case "SAN JOSE":
//                        sj++;
//                        break;
//                    case "ALAJUELA":
//                        al++;
//                        break;
//                    case "LIMON":
//                        lm++;
//                        break;
//                    case "HEREDIA":
//                        hd++;
//                        break;
//                    case "PUNTARENAS":
//                        ptn++;
//                        break;
//                    case "GUANACASTE":
//                        gt++;
//                        break;
//                    case "CARTAGO":
//                        ctg++;
//                        break;
//                    case "CONSULADO":
//                        cns++;
//                        break;
//                }
//            }
//        }
//        System.out.println("Estadisticas: \n SAN JOSE: " + sj + "\n"
//                + " ALAJUELA:" + al + "\n LIMON: " + lm + " \n HEREDIA: " + hd + " \n"
//                + "PUNTARENAS: " + ptn + " \n GUANACASTE:" + gt + "\n"
//                + "CARTAGO: " + ctg + " \n CONSULADO: " + cns);
//    }

}
