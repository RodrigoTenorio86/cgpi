
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

public class Poligono2D {

    private ArrayList<Ponto2D> listadepontos;
    private ArrayList<Reta2D> listaderetas;
    private Color cor;
    private String str;

    Poligono2D() {
        listadepontos = new ArrayList<Ponto2D>();
        listaderetas= new ArrayList<Reta2D>();
        cor = Color.blue;
        str = "";
    }

    Poligono2D(Ponto2D p1, Color cor, String str) {
        this.cor = cor;
        this.str = str;
        listadepontos = new ArrayList<Ponto2D>();
        listadepontos.add(p1);
    }

    public int getQtdDepontos() {
        return listadepontos.size();
    }

    public void addPonto(Ponto2D p) {
        System.out.println(p.getX()+" , "+p.getY());
        this.listadepontos.add(p);
    }

    public void desenharPoligono(Graphics g) {
    
        if (listadepontos.size() > 2) {
            //Ponto p1 = listadepontos.get(1);
            Reta2D r;
            for (int i = 1; i < listadepontos.size(); i++) {
                
                r = new Reta2D(listadepontos.get(i - 1), listadepontos.get(i), cor, str);
                r.desenharReta(g);
                listaderetas.add(r);
            }
            if (listadepontos.size() > 2) {
                r = new Reta2D((listadepontos.get(listadepontos.size() - 1)), (listadepontos.get(0)), cor, str);
                r.desenharReta(g);
                listaderetas.add(r);
            }
        }
    }
    
    public boolean pertence(int x, int y){
        for (Reta2D r: listaderetas) {
            if (r.pertenceReta(x, y)) return true;
        }
        return false;
    }
    
    public void setCor(Color cor){
        this.cor=cor;
    }
    
    
}
