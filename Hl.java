import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Hl extends JPanel implements MouseListener, KeyListener, ActionListener
{
  int x = 50;
  int y = 50;
  int xWall = 0;
  int yWall = 0;
  boolean r = false;
  boolean u = false;
  boolean d = false;
  boolean l = false;
  boolean wallHit = false;
  boolean clicked;
  Timer t;
  ArrayList<TrafficCone> mCones;
  ArrayList<Walls> blocks;
  
  public Hl()
  {
    addMouseListener(this);
    addKeyListener(this);
    mCones = new ArrayList<TrafficCone>(3);
    mCones.add(new TrafficCone(100,100));
    mCones.add(new TrafficCone(300,150));
    mCones.add(new TrafficCone(250,300));
    blocks = new ArrayList<Walls>(4);
    blocks.add(new Walls(400,100));
    blocks.add(new Walls(400,150));
    blocks.add(new Walls(400,250));
    blocks.add(new Walls(350,50));
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

    for (TrafficCone t : mCones){
      t.draw(g);
    }
    
    for (Walls w : blocks){
      w.paint(g);
    }
  }
  public void actionPerformed(ActionEvent avt)
  {
    for(Walls w: blocks)
    {
      if(r||l)
      {
        w.sideWallHit(x,y,x+50,y+20);
      }
      if(u||d)
      {
        w.vertWallHit(x,y,x+50,y+20);
      }
      if(w.sideHit||w.vertHit)
      {
        if((r||l)&&w.sideHit)
          x = w.sideWallHit(x,y,x+50,y+20);
        if((u||d)&&w.vertHit)
          y = w.vertWallHit(x,y,x+50,y+20);
      }
    }
    
    if(r)
      x+=2;
    else if(l)
      x-=2;
    else if(u)
      y-=2;
    else if(d)
      y+=2;
//    }
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
    if(kvt.getKeyChar()=='w'&& clicked)
    {
      blocks.add(new Walls(xWall,yWall));
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
    requestFocus();
    clicked = true;
    xWall = evt.getX();
    yWall = evt.getY();
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
    {}
  }

}
