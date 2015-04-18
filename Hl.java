import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Hl extends JPanel implements MouseListener, KeyListener, ActionListener
{
  int x = 50;
  int y = 50;
  boolean r = false;
  boolean u = false;
  boolean d = false;
  boolean l = false;
  Timer t;
  ArrayList<TrafficCone> mCones;
  
  public Hl()
  {
    addMouseListener(this);
    addKeyListener(this);
    mCones = new ArrayList<TrafficCone>(3);
    mCones.add(new TrafficCone(100,100));
    mCones.add(new TrafficCone(300,150));
    mCones.add(new TrafficCone(250,300));
  //  ActionListener al = new ActionListener();
    t = new Timer(10,new TimerActionListener());
    t.addActionListener(this);
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.fillRect(x,y,50,15);
    g.setColor(Color.BLACK);
    g.fillOval(x,y+15,5,5);
    g.fillOval(x+45,y+15,5,5);
    g.setColor(Color.BLACK);
    g.fillRect(1000,0,20,1000);

    for (TrafficCone t : mCones){
      t.draw(g);
    }
  }
//  public void walls(Graphics g)
//  {
//  }
  public void actionPerformed(ActionEvent avt)
  {
    if(r&&x<950)
      x+=2;
    else if(l)
      x-=2;
    else if(u)
      y-=2;
    else if(d)
      y+=2;
    for(TrafficCone c: mCones){
      if (c.didHit(x,y,x+50,y+15))
      {
        c.knockOver();
      }
    }
    repaint();
  }
  public void keyPressed(KeyEvent kvt)
  {
    if(kvt.getKeyCode()==KeyEvent.VK_RIGHT)
    {
      //System.out.println("pressed");
      //n+=5;
      r = true;
      t.start();
      repaint();
    }
    else if(kvt.getKeyCode()==KeyEvent.VK_UP)
    {
      u = true;
      t.start();
      repaint();
    }
    else if(kvt.getKeyCode()==KeyEvent.VK_DOWN)
    {
      d = true;
      t.start();
      repaint();
    }
    else if(kvt.getKeyCode()==KeyEvent.VK_LEFT)
    {
      l = true;
      t.start();
      repaint();
    }
    if(kvt.getKeyChar()=='n')
    {
      mCones.add(new TrafficCone((int)(Math.random()*500+50),(int)(Math.random()*500+50)));
      repaint();
    }
  }
  public void keyReleased(KeyEvent kvt)
  {
    System.out.println("released");
    t.stop();
    r = false;
    u = false;
    d = false;
    l = false;
  }
  public void keyTyped(KeyEvent kvt){System.out.println("typed");}
  public void mouseClicked(MouseEvent evt)
  {
    //  while(n<1000)
    //{
    //n+=5;
    //repaint();
    requestFocus();
    //}
  }
  public void mousePressed(MouseEvent evt)
  {
    t.start();
  }
  public void mouseReleased(MouseEvent evt)
  {
    t.stop();
  }
  public void mouseEntered(MouseEvent evt){}
  public void mouseExited(MouseEvent evt){}
  
    class TimerActionListener implements ActionListener 
  { 
    public void actionPerformed(ActionEvent e) 
    { 
      //repaint();
        
      //makeMove( opponent.nextMove(theBoard) );
    }
  }

}
