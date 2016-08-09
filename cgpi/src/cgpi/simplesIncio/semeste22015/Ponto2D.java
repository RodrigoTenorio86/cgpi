
/**
 *
 * @author RodrigoTenorio
 */
/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpi.simplesIncio.semeste22015;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
public class Ponto2D extends Ponto {
   Color _cor;
   String _str;
   Color _corStr;
   Ellipse2D ov;
   
   Ponto2D(int x, int y, Color cor){
      super((double)x, (double)y);
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr("");
      this.ov=new Ellipse2D.Double(getX(),getY(),3,3);
   }

   Ponto2D(int x, int y, Color cor, String str){
      super((double)x, (double)y);
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr(str);
      this.ov=new Ellipse2D.Double(getX(),getY(),3,3);
   }

   Ponto2D(Ponto2D p2d, Color cor){
      super(p2d);	 
      setCor(cor);	 
      setCorStr(Color.black);	 
      setStr("");
      this.ov=new Ellipse2D.Double(getX(),getY(),3,3);
  }
   
   Ponto2D(){
      super();	 
      setCor(Color.black);	 
      setCorStr(Color.black);	 
      setStr("");
      this.ov=new Ellipse2D.Double(getX(),getY(),3,3);
  }
   
   private void setCor(Color cor){
   	  _cor = cor;
   }
   private void setCorStr(Color corStr){
   	  _corStr = corStr;
   }
   private void setStr(String str){
   	  _str = str;
   }
   
//   public void desenharPonto(Graphics g){
//       g.setColor(_cor);
//   	   g.drawLine((int)getX(), (int)getY(), (int)getX(), (int)getY());

//       g.setColor(_corStr);
//       g.drawString(_str, (int)getX() + 5, (int)getY());
//   }
   
   public void desenharPonto(Graphics g){
       g.setColor(_cor);
       g.fillOval((int)getX() -1, (int)getY() -1, 3, 3);// mais visivel (r = 3 pixels)
       
       g.setColor(_corStr);
       g.drawString(_str, (int)getX() + 5, (int)getY());
       
   }
   
   public boolean pertence(int x, int y){
       
       return (ov.contains(new Point2D.Double(x,y)));
       
   }
}
