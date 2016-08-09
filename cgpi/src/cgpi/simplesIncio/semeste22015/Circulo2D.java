
/**
 *
 * @author RodrigoTenorio
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.simplesIncio.semeste22015;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Circulo2D extends Circulo {

    private Color cor;
    private String str;
    private ArrayList<Ponto2D> listadepontos;

    Circulo2D(int x1, int y1, double r, Color cor, String str) {
        super(x1, y1, r);
        listadepontos = new ArrayList<Ponto2D>();
        setCor(cor);
        setStr(str);

    }

    Circulo2D(Ponto p1, Ponto p2) {
        super(p1, p2);
        listadepontos = new ArrayList<Ponto2D>();
    }
    
    Circulo2D(Ponto p1, Ponto p2, Color cor, String str) {
        super(p1, p2);
        listadepontos = new ArrayList<Ponto2D>();
        setCor(cor);
        setStr(str);
    }
    
    Circulo2D(int x1, int y1, double r, Color cor) {
        super(x1, y1, r);
        listadepontos = new ArrayList<Ponto2D>();
        setCor(cor);
        setStr(str);

    }
    

    
    

    public void desenharCirculo(Graphics g, int dots) {
        double xd, yd;
        double pi = Math.PI;
        //System.out.println("Centro:" +this.centro.getX()+","+this.centro.getY());
        if (this.raio > 0) {
            for (int k = 1; k <= dots; k++) {
                xd = raio * Math.cos((2 * pi / dots) * (k - 1)) + this.centro.getX();
                yd = raio * Math.sin((2 * pi / dots) * (k - 1)) + this.centro.getY();
                Ponto2D p = new Ponto2D((int) xd, (int) yd, Color.blue);
                p.desenharPonto(g);
            }
        }

    }

    public void desenharCirculoOpt1(Graphics g, int dots) {
        double xd, yd, xd2, yd2;
        double pi = 3.141592;
        //System.out.println("Centro:" +this.centro.getX()+","+this.centro.getY());
        if (this.raio > 0) {
            for (int k = 1; k <= dots; k++) {
                xd = raio * Math.cos((pi / 2 / dots) * (k - 1)) + this.centro.getX();
                yd = raio * Math.sin((pi / 2 / dots) * (k - 1)) + this.centro.getY();
                xd2 = xd - 2 * (xd - this.centro.getX());
                yd2 = yd - 2 * (yd - this.centro.getY());
                Ponto2D p = new Ponto2D((int) xd, (int) yd, cor);
                Ponto2D p1 = new Ponto2D((int) xd2, (int) yd, cor);
                Ponto2D p2 = new Ponto2D((int) xd, (int) yd2, cor);
                Ponto2D p3 = new Ponto2D((int) xd2, (int) yd2, cor);
                
                p.desenharPonto(g);
                p1.desenharPonto(g);
                p2.desenharPonto(g);
                p3.desenharPonto(g);
                
                listadepontos.add(p);
                listadepontos.add(p1);
                listadepontos.add(p2);
                listadepontos.add(p3);
                //System.out.println(p.getX() +" "+ p1.getX() +" "+ p2.getX() +" "+ p3.getX());
            }
        }
 }

    
public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Color getCor() {
        return cor;
    }

    public String getStr() {
        return str;
    }
    
    public boolean pertence(int x, int y){
        for (Ponto2D p: listadepontos){
            if (p.pertence(x, y))
                return true;
        }
        return false;
    }
}
