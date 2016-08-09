
/**
 *
 * @author RodrigoTenorio
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.simplesIncio.semeste22015;

public class Circulo {
    
    Ponto centro;
    Double raio;
    
     Circulo(int x1, int y1, double R){
    	setCentro(new Ponto(x1, y1));
        this.raio=R;
    }    
   	
    Circulo(Ponto p1, Ponto p2){
    	setCentro(p1);
        this.raio=p1.calcularDistancia(p2);
    }    

	
	//Sets
    
    public void setCentro(Ponto p){
        this.centro=p;
    }
   

	
	//Gets
    public Ponto getCentro() {
        return this.centro;
    }
    
    public double getRaio() {
        return this.raio;
    }

}
