/**
 * @author RodrigoTenorio
 */

/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.semestre22015;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Programa extends JFrame implements MouseMotionListener, MouseListener {

	int _x, _y;
        private ArrayList<Ponto2D> listadepontos;
	
	public Programa() {

		/**
		 * Definicoes de janela
		 */
		super("Programa"); 
                listadepontos=new ArrayList<Ponto2D>();

		// Eventos de mouse
		addMouseListener(this);
		addMouseMotionListener(this);

	}

    public void paint(Graphics g) {
    	  	   	
	    Ponto2D p; 

        // Cria um ponto
		p = new Ponto2D(_x, _y, Color.blue, "P");

    	// Desenha o ponto
		p.desenharPonto(g);
                listadepontos.add(p);
                if (listadepontos.size()>3){
                    Reta2D r=new Reta2D(listadepontos.get(listadepontos.size()-2),listadepontos.get(listadepontos.size()-1),Color.blue, "R");
                    Circulo2D c=new Circulo2D(listadepontos.get(listadepontos.size()-2),listadepontos.get(listadepontos.size()-1));
                    r.desenharReta(g);
                    //c.desenharCirculo(g, 720);
                    c.desenharCirculoOpt1(g, 720);
                }

    }

	
	public static void main(String args[]) {
		Programa p = new Programa();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(500,500);
		p.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		setTitle("Programa"+" (" + e.getX() + ", " + e.getY() + ")");
	}
	public void mousePressed(MouseEvent mouseevent) {
		if (mouseevent.getButton() == 1) {
			_x = mouseevent.getX();
			_y = mouseevent.getY();
		}
		repaint(); // redesenha
	}

	public void mouseClicked(MouseEvent mouseevent)	{
	}

	public void mouseEntered(MouseEvent mouseevent) {
	}

	public void mouseExited(MouseEvent mouseevent) {
	}

	public void mouseReleased(MouseEvent mouseevent) {
	}

}

