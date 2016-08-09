
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
public class Retangulo2D extends Retangulo {

    Color cor;
    String str;
    Reta2D r1, r2, r3, r4;

    Retangulo2D(Ponto p1, Ponto p2, Color cor, String str) {
        super(p1, p2);
        this.cor = cor;
        this.str = str;
    }

    public void desenharRetangulo(Graphics g) {
       
        double difx = this.getP1().getX() - this.getP2().getX();
        double dify = this.getP1().getY() - this.getP2().getY();
        if (difx < 0) {
            difx = difx * -1;
        }
        if (dify < 0) {
            dify = dify * -1;
        }
        if ((difx > 5 && dify > 5)) {
            this.r1 = new Reta2D(this.getP1(), this.getP3(), cor, str);
            this.r2 = new Reta2D(this.getP3(), this.getP2(), cor, str);
            this.r3 = new Reta2D(this.getP2(), this.getP4(), cor, str);
            this.r4 = new Reta2D(this.getP4(), this.getP1(), cor, str);
            this.r1.desenharReta(g);
            this.r2.desenharReta(g);
            this.r3.desenharReta(g);
            this.r4.desenharReta(g);
            
         
        } else {
            System.out.println("Retangulo pequeno demais: " + (this.getP1().getX() - this.getP2().getX()) + "  " + (this.getP1().getY() - this.getP2().getY()));
        }

    }
    
    public boolean pertence(int x, int y){
        if (r1.pertenceReta(x, y) || r4.pertenceReta(x, y) || r2.pertenceReta(x, y) || r3.pertenceReta(x, y)) {
            return true;
        }
        return false;
    }
    
    
}
