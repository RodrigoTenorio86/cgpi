/**
 * 
 * @author RodrigoTenorio
 *
 */
package cgpi;

public class Circulo {

	private Ponto centro;
	private double raio;
	
	protected Circulo(Ponto centro, double raio){
		this.centro = centro;
		this.raio = raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	public void setCentro(Ponto centro) {
		this.centro = centro;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}


}
