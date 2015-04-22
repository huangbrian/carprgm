import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Walls
{
  private int mX;
  private int mY;
  protected boolean sideHit = false;
  protected boolean vertHit = false;
  
  Walls(int x, int y)
  {
    mX = x;
    mY = y;
  }
  
  public void paint(Graphics g)
  {
    g.setColor(Color.BLACK);
    g.fillRect(mX,mY,50,50);
  }
  
  public int sideWallHit(int x1, int y1, int x2, int y2)
  {
    if((mX<=x2 && mX+50>=x2 && mY+2<=y2 && mY+50>=y2)||(mX<=x2 && mX+50>=x2 && mY<=y1 && mY+48>=y1))
    {
      x1-=2;
      System.out.println("hit3");
      sideHit = true;
      vertHit = false;
      return x1;
    }
    else if((mX<=x1 && mX+50>=x1 && mY+2<=y2 && mY+50>=y2)||(mX<=x1 && mX+50>=x1 && mY<=y1 && mY+48>=y1))
    {
      x1+=2;
      System.out.println("hit4");
      sideHit = true;
      vertHit = false;
      return x1;
    }
    else
    {
      sideHit = false;
      return x1;
    }
  }
  public int vertWallHit(int x1, int y1, int x2, int y2)
  {
    if((mX<=x1 && mX+48>=x1 && mY<=y2 && mY+50>=y2)||(mX+2<=x2 && mX+50>=x2 && mY<=y2 && mY+50>=y2))
    {
      y1-=2;
      System.out.println("hit1");
      vertHit = true;
      sideHit = false;
      return y1;
    }
    else if((mX<=x1 && mX+48>=x1 && mY<=y1 && mY+50>=y1)||(mX+2<=x2 && mX+50>=x2 && mY<=y1 && mY+50>=y1))
    {
      y1+=2;
      System.out.println("hit2");
      vertHit = true;
      sideHit = false;
      return y1;
    }
    else
    {
      vertHit = false;
      return y1;
    }
  }
}