
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

public class Reta2D extends Reta {

    Color cor;
    String str;
    private ArrayList<Ponto2D> listadepontos;

    Reta2D(int x1, int y1, int x2, int y2, Color cor, String str) {
        super(x1, y1, x2, y2);
        listadepontos = new ArrayList<Ponto2D>();

        setCor(cor);
        setStr(str);

    }

    Reta2D(Ponto p1, Ponto p2, Color cor, String str) {

        super(p1, p2);
        listadepontos = new ArrayList<Ponto2D>();
        setCor(cor);
        setStr(str);
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
    //Método para desenhar a Reta: foi dividido em casos

    public void desenharReta(Graphics g) {

        double b = calculaB();
        double m = calculaM();


        //Caso 1) Caso em que o intervalo em y é maior
        if (Math.abs(p2.getY() - p1.getY()) > Math.abs(p2.getX() - p1.getX())) {

            //Caso 1.1)Caso em que y1 > y2
            if (p1.getY() > p2.getY()) {

                //System.out.println("Intervalo em Y eh maior com y1 > y2 .");
                if (p1.getX() == p2.getX()) {
                    Ponto2D ponto = new Ponto2D((int) p1.getX(), (int) p1.getY(), cor, str);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                    for (double y = p2.getY(); y < p1.getY(); ++y) {
                        ponto = new Ponto2D((int) (p1.getX()), (int) y, cor);
                        ponto.desenharPonto(g);
                        listadepontos.add(ponto);

                    }
                } else {
                    Ponto2D ponto = new Ponto2D((int) p2.getX(), (int) p2.getY(), cor, str);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                    for (double y = p2.getY(); y < p1.getY(); ++y) {
                        ponto = new Ponto2D((int) ((y - b) / m), (int) y, cor);
                        ponto.desenharPonto(g);
                        listadepontos.add(ponto);
                    }
                }

                //Caso 1.2)Caso em que x1 = x2
            } else if (p1.getX() == p2.getX()) {

                //System.out.println("Intervalo em Y eh maior com Reta vertical .");
                Ponto2D ponto = new Ponto2D((int) p1.getX(), (int) p1.getY(), cor, str);
                ponto.desenharPonto(g);
                for (double y = p1.getY(); y < p2.getY(); ++y) {
                    ponto = new Ponto2D((int) (p1.getX()), (int) y, cor);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                }
                //Caso 1.3)Caso em que x1 < x2	
            } else {

                //System.out.println("Intervalo em Y eh maior com x1 < x2 .");
                Ponto2D ponto = new Ponto2D((int) p1.getX(), (int) p1.getY(), cor, str);
                ponto.desenharPonto(g);
                for (double y = p1.getY(); y < p2.getY(); ++y) {
                    ponto = new Ponto2D((int) ((y - b) / m), (int) y, cor);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                }

            }

            //Caso 2)Caso em que o intervalo em x é maior
        } else {

            //Caso 2.1)Caso em que x1 > x2
            if (p1.getX() > p2.getX()) {

                //System.out.println("Intervalo em X eh maior com x1 > x2 .");
                Ponto2D ponto = new Ponto2D((int) p2.getX(), (int) p2.getY(), cor, str);
                ponto.desenharPonto(g);
                listadepontos.add(ponto);
                for (double x = p2.getX(); x < p1.getX(); ++x) {
                    ponto = new Ponto2D((int) x, (int) (b + m * x), cor);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                }

                //Caso 2.2)Caso em que x1 = x2	
            } else if (p1.getX() == p2.getX()) {

                //System.out.println("Intervalo em X eh maior com Reta Vertical .");
                Ponto2D ponto = new Ponto2D((int) p1.getX(), (int) p1.getY(), cor, str);
                ponto.desenharPonto(g);
                listadepontos.add(ponto);
                for (double x = p1.getX(); x < p2.getX(); ++x) {
                    ponto = new Ponto2D((int) (p1.getX()), (int) (b + m * x), cor);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                }

                //Caso 2.3)Caso em que x1 < x2
            } else {

                //System.out.println("Intervalo em X eh maior com x1 < x2 .");
                Ponto2D ponto = new Ponto2D((int) p1.getX(), (int) p1.getY(), cor, str);
                ponto.desenharPonto(g);
                listadepontos.add(ponto);
                for (double x = p1.getX(); x < p2.getX(); ++x) {
                    ponto = new Ponto2D((int) x, (int) (b + m * x), cor);
                    ponto.desenharPonto(g);
                    listadepontos.add(ponto);
                }
            }
        }

    }

    public boolean pertenceReta(int x, int y) {
        for (Ponto2D p : listadepontos ) {
            if (p.pertence(x, y)) return true;
        }
        return false;
    }
}
