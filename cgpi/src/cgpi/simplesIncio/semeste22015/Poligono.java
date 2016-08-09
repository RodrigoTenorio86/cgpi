
/**
 *
 * @author RodrigoTenorio
 */
/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.simplesIncio.semeste22015;

import java.util.ArrayList;

public class Poligono {
    private ArrayList<Ponto> listadepontos;
    
    Poligono(){
        listadepontos=new ArrayList<Ponto>();
        
    }
    
    Poligono(Ponto p1){
        listadepontos=new ArrayList<Ponto>();
        listadepontos.add(p1);
    }
    
    public void addPonto(Ponto p){
        this.listadepontos.add(p);
    }
}
