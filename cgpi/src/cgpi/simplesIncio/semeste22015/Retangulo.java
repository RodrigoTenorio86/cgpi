
/**
 *
 * @author RodrigoTenorio
 */
/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.simplesIncio.semeste22015;

public class Retangulo {
    private Ponto p1, p2, p3, p4;
    
    Retangulo(Ponto p1, Ponto p2){
        this.p1=p1;
        this.p2=p2;
        this.p3=new Ponto(this.p2.getX(),this.p1.getY());
        this.p4=new Ponto(this.p1.getX(),this.p2.getY());
    }

    public Ponto getP1() {
        return p1;
    }

    public void setP1(Ponto p1) {
        this.p1 = p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public void setP2(Ponto p2) {
        this.p2 = p2;
    }

    public Ponto getP3() {
        return p3;
    }

    public void setP3(Ponto p3) {
        this.p3 = p3;
    }

    public Ponto getP4() {
        return p4;
    }

    public void setP4(Ponto p4) {
        this.p4 = p4;
    }
    
}
