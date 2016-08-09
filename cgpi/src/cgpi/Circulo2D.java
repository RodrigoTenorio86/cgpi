package cgpi;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo2D extends Circulo{
	private Color cor;
	private String nome;
	
	public Circulo2D(Ponto centro, double raio, Color cor, String str) {
		super(centro, raio);
		setCor(cor);
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void desenharCirculo(Graphics g) {
		if (getRaio() != 0) {

			int x = 0;
			int y = (int)getRaio();
			
			for (double alfa = 0; alfa <= 45; alfa = alfa + 0.15) {
				
				x = (int) (getRaio() * Math.cos((alfa * Math.PI) / 180.));
				y = (int) (getRaio() * Math.sin((alfa * Math.PI) / 180.));

				Ponto2D ponto = new Ponto2D((int) getCentro().getX() + x, (int)getCentro().getY() + y, cor); 
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D ((int) getCentro().getX() + y, (int)getCentro().getY() + x, cor);
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D((int) getCentro().getX() + y, (int)getCentro().getY() - x, cor);
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D((int) getCentro().getX() + x, (int)getCentro().getY() - y, cor);
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D((int) getCentro().getX() - x, (int)getCentro().getY() - y, cor);
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D((int) getCentro().getX() - y, (int)getCentro().getY() - x, cor);
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D((int) getCentro().getX() - y, (int)getCentro().getY() + x, cor);
				ponto.desenharPonto(g);
				
				ponto = new Ponto2D((int) getCentro().getX() - x, (int)getCentro().getY() + y, cor);
				ponto.desenharPonto(g);
			}
					
	}
		
	}

}
