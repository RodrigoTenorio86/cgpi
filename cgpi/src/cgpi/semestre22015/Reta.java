/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.semestre22015;


public class Reta{
	
    Ponto p1, p2;
    
    //Construtores
    Reta(int x1, int y1, int x2, int y2){
    	
    	setP1(new Ponto(x1, y1));
        setP2(new Ponto(x2, y2));
    }    
   	
    Reta(Ponto p1, Ponto p2){
    	setP1(new Ponto(p1));
        setP2(new Ponto(p2));
    }    
	
	//Sets
	public void setP1(Ponto p1) {
		this.p1 = p1;
	}
	
	public void setP2(Ponto p2) {
		this.p2 = p2;
	}
	
	
	//Gets
	public Ponto getP1() {
		return p1;
	}
	
	public Ponto getP2() {
		return p2;
	}
	
	
	//Calcula m da equação da reta (y = m*x + b)
	public double calculaM(){
		
		double m=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
		return m;
	}
	
	//Calcula b da equação da reta (y = m*x + b)
	public double calculaB(){
		
		double m=calculaM();
		double b=p2.getY()-(m*p2.getX());
		return b;
	}
	
   	
}




/**
 * @author RodrigoTenorio
 */