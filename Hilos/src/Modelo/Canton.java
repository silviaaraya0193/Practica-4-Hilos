/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author viccr
 */
public class Canton {
    String codElect,canton;
    public Canton(String codElec,String canton){
    this.canton=canton;
    this.codElect=codElec;
      } 

    public String getCodElect() {
        return codElect;
    }

    public void setCodElect(String codElect) {
        this.codElect = codElect;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }
    
}
