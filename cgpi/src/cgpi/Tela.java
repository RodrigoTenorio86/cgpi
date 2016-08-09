/**
 * 
 * @author RodrigoTenorio
 *
 */
package cgpi;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class Tela extends JFrame {
private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	public Tela() {
		
		/**
		 * Definicoes de janela
		 */
		super("Formas Simples");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();

	}

    public void paint(Graphics g) {
 	    
    	Ponto2D ponto[]; // coordenadas capturadas pelo mouse

		// Cria um vetor de 3 pontos
		ponto = new Ponto2D[3];

		// Define 3 pontos
		ponto[0] = new Ponto2D(100, 100, Color.blue, "P1");
		ponto[1] = new Ponto2D(200, 200, Color.red, "P2");
		ponto[2] = new Ponto2D(100, 300, Color.green, "P3");

		//Define um vetor de 2 pontos 
		Ponto2D pontos[] = new Ponto2D[2];

		//Define 2 pontos
		pontos[0] = new Ponto2D(0, 0, Color.magenta, "Comeco");
		pontos[1] = new Ponto2D(200, 200, Color.blue, "Final");

		//Define uma reta	
		Reta2D reta = new Reta2D(pontos[0], pontos[1], Color.magenta, "");
		Reta2D reta1 = new Reta2D(ponto[0], ponto[2], Color.PINK, "");
		
		//Define um circulo
		Circulo2D circulo = new Circulo2D (pontos[1],150, Color.blue, "");
		
		//Desenha as Formas Simples
		ponto[0].desenharPonto(g);
    	ponto[1].desenharPonto(g);
    	ponto[2].desenharPonto(g);
		reta.desenharReta(g);
		reta1.desenharReta(g);
		circulo.desenharCirculo(g);    	
    }

}
