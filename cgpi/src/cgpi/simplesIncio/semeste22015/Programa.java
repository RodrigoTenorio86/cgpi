
/**
 *
 * @author RodrigoTenorio
 */
/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.simplesIncio.semeste22015;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



class Programa extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int _x, _y;
    int largura = 700, altura = 500;
    int circuloDots=240;
    String modo = "";
    private ArrayList<Ponto2D> listaTemporariadePontos;
    private ArrayList<Ponto2D> listadePontos;
    private ArrayList<Retangulo2D> listadeRetangulos;
    private ArrayList<Reta2D> listadeRetas;
    private ArrayList<Circulo2D> listadeCirculos;
    private ArrayList<Poligono2D> listadePoligonos;
    Button triButton, retaButton, rtgButton, circButton, dotButton, poliButton;
    
    Poligono2D tmpPoli;

    public Programa() {

        /**
         * Definicoes de janela
         */
        super("Programa");
        listaTemporariadePontos = new ArrayList<Ponto2D>();
        listadeRetas=new ArrayList<Reta2D>();
        listadeRetangulos=new ArrayList<Retangulo2D>();
        listadeCirculos=new ArrayList<Circulo2D>();
        listadePontos=new ArrayList<Ponto2D>();
        listadePoligonos=new ArrayList<Poligono2D>();
        
        // Eventos de mouse
        
        this.setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
        Container content = this.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());
        JButton removeButton = new JButton("Remove");
        JButton retaButton = new JButton("Reta");
        JButton rtgButton = new JButton("Retangulo");
        JButton circButton = new JButton("Circulo");
        JButton dotButton = new JButton("Ponto");
        JButton poliButton=new JButton("Poligono");
        
        dotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modo="ponto";
                listaTemporariadePontos.clear();
            }
        });



        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modo="remove";
                listaTemporariadePontos.clear();
            }
        });
        retaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modo="reta";
                listaTemporariadePontos.clear();
            }
        });
        rtgButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modo="retangulo";
                listaTemporariadePontos.clear();
            }
        });
        circButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modo="circulo";
                listaTemporariadePontos.clear();
            }
        });
        
        poliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                modo="poligono";
                listaTemporariadePontos.clear();
                
                
                
            }
        });

        content.add(removeButton);
        content.add(retaButton);
        content.add(rtgButton);
        content.add(circButton);
        content.add(dotButton);
        content.add(poliButton);

        retaButton.isEnabled();
    }

    public void paint(Graphics g) {
      
        
        if (modo=="ponto"){
            Ponto2D p;
            p = new Ponto2D(_x, _y, Color.blue, "P");
            listadePontos.add(p);
            //p.desenharPonto(g);
        }
        
        else if (modo=="circulo"){
            if (listaTemporariadePontos.size()==0){
                Ponto2D p;
                p = new Ponto2D(_x, _y, Color.blue, "");
                listaTemporariadePontos.add(p);
                
                }
            else if ( listaTemporariadePontos.size()==1){
                Ponto2D p;
                p = new Ponto2D(_x, _y, Color.blue, "");
                Circulo2D c = new Circulo2D(listaTemporariadePontos.get(listaTemporariadePontos.size() - 1), p, Color.blue, "C");
                
                listadeCirculos.add(c);
                listaTemporariadePontos.clear();
            }
            
            
        }
        
       
       else if (modo=="retangulo"){
            if (listaTemporariadePontos.size()==0){
                Ponto2D p;
                p = new Ponto2D(_x, _y, Color.blue, "");
                listaTemporariadePontos.add(p);
                
                }
            else if ( listaTemporariadePontos.size()==1){
                Ponto2D p;
                p = new Ponto2D(_x, _y, Color.blue, "");
                Retangulo2D ret = new Retangulo2D(listaTemporariadePontos.get(listaTemporariadePontos.size() - 1), p, Color.blue, "");
                //ret.desenharRetangulo(g);
                listadeRetangulos.add(ret);
                listaTemporariadePontos.clear();
            }
            
            
        }
        
        else if (modo=="reta"){
            if (listaTemporariadePontos.size()==0){
                Ponto2D p;
                p = new Ponto2D(_x, _y, Color.blue, "");
                listaTemporariadePontos.add(p);
                
                }
            else if ( listaTemporariadePontos.size()==1){
                Ponto2D p;
                p = new Ponto2D(_x, _y, Color.blue, "");
                Reta2D reta = new Reta2D(listaTemporariadePontos.get(listaTemporariadePontos.size() - 1), p, Color.blue, "");
                //reta.desenharReta(g);
                listadeRetas.add(reta);
                listaTemporariadePontos.clear();
            }
        }
        
        else if (modo=="poligono"){
               listaTemporariadePontos.add(new Ponto2D(_x,_y, Color.blue, ""));
        }
        
        
        else if (modo=="remove"){
            Reta2D tmp;
            Retangulo2D rtgtmp;
            Circulo2D crctmp;
            
            for (Reta2D r: listadeRetas){
                if (r.pertenceReta(_x, _y)) {
                    tmp=new Reta2D(r.getP1(), r.getP2(), Color.white, ""  );
                    tmp.desenharReta(g);
                    listadeRetas.remove(r);
                    
                    return;
                }
            }
            for (Retangulo2D rtg: listadeRetangulos){
                if (rtg.pertence(_x, _y)) {
                    
                    rtgtmp=new Retangulo2D(rtg.getP1(), rtg.getP2(), Color.white, ""  );
                    rtgtmp.desenharRetangulo(g);
                    listadeRetangulos.remove(rtg);
                    //System.out.println(" tamanho:"+ listadeRetangulos.size());
                    return;
                }
            }
            
            for (Circulo2D crc: listadeCirculos ) {
                if (crc.pertence(_x, _y)){
                    crctmp=new Circulo2D((int)crc.getCentro().getX(),(int)crc.getCentro().getY(), crc.raio, Color.white, "" );
                    crctmp.desenharCirculoOpt1(g, circuloDots);
                    listadeCirculos.remove(crc);
                    return;
                }
            }
            
            for (Poligono2D poli: listadePoligonos ) {
                if (poli.pertence(_x, _y)){
                    poli.setCor(Color.white);
                    poli.desenharPoligono(g);
                    listadePoligonos.remove(poli);
                    return;
                }
            }
            
           
        }
        drawStuff(g);

    }

    
    public void drawStuff(Graphics g) {
        for (Reta2D r: listadeRetas){
             r.desenharReta(g);
        }
        for (Circulo2D c: listadeCirculos){
             c.desenharCirculoOpt1(g, circuloDots);
        }
        
        for (Retangulo2D rtg: listadeRetangulos){
             rtg.desenharRetangulo(g);
        }
        for (Ponto2D p: listadePontos){
             p.desenharPonto(g);
        }
        for (Poligono2D poli: listadePoligonos){
             poli.desenharPoligono(g);
        }
    }
    
    public static void main(String args[]) {
        Programa p = new Programa();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setSize(p.largura, p.altura);
        p.setVisible(true);




    }

    public void actionPerformed(ActionEvent e) {
        
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
        setTitle("Programa" + " (" + e.getX() + ", " + e.getY() + ")");
        repaint();
    }

    public void mousePressed(MouseEvent mouseevent) {
        if (mouseevent.getButton() == 1) {
           
            _x = mouseevent.getX();
            _y = mouseevent.getY();
            // inverte eixo x
            //_y = inverteEixoY(_y);
        }
        else if(mouseevent.getButton()==3){
            
                if (modo=="poligono"){ 
                    
                    Poligono2D poli;
                    poli=null;
                    poli=new Poligono2D();
                    for (Ponto2D p: listaTemporariadePontos) {
                        poli.addPonto(p);
                    }
                    listadePoligonos.add(poli);
                    listaTemporariadePontos.clear();
                    modo="";
                    
                }
                
        }
        repaint(); // redesenha
    }

    public void mouseClicked(MouseEvent mouseevent) {
    }

    public void mouseEntered(MouseEvent mouseevent) {
    }

    public void mouseExited(MouseEvent mouseevent) {
    }

    public void mouseReleased(MouseEvent mouseevent) {
    }

    public int inverteEixoY(int y) {
        y = altura - y;
        return y;
    }
}
