import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Walls
{
  private int mX;
  private int mY;
  protected boolean hit = false;
  
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
  
//  public boolean hitWall(int x1, int y1, int x2, int y2)
//  {
//    if((mX<=x1 && mX+50>=x1 && mY<=y1 && mY+50>=y1)||
//      (mX<=x2 && mX+50>=x2 && mY<=y2 && mY+50>=y2)||
//      (mX<=x2 && mX+50>=x2 && mY<=y1 && mY+50>=y1)||
//      (mX<=x1 && mX+50>=x1 && mY<=y2 && mY+50>=y2)||
//      (mX>=x1 && mX<=x2 && mY>=y1 && mY<=y2)||
//      (mX+50>=x1 && mX+50<=x2 && mY+50>=y1 && mY+50<=y2))
//    {
//      return true;
//    }
//    else
//    {
//      return false;
//    }
//  }
  public int wallHit(int x1, int y1, int x2, int y2)
  {
    if((mX<=x1 && mX+50>=x1 && mY<=y2 && mY+30>=y2)||(mX<=x2 && mX+50>=x2 && mY<=y2 && mY+30>=y2))
    {
      y1-=2;
      System.out.println("hit1");
      hit = true;
      return y1;
    }
    else if((mX<=x1 && mX+50>=x1 && mY+20<=y1 && mY+50>=y1)||(mX<=x2 && mX+50>=x2 && mY+20<=y1 && mY+50>=y1))
    {
      y1+=2;
      System.out.println("hit2");
      hit = true;
      return y1;
    }
    else if((mX<=x2 && mX+30>=x2 && mY<=y2 && mY+50>=y2)||(mX<=x1 && mX+30>=x1 && mY<=y1 && mY+50>=y1))
    {
      x1-=2;
      System.out.println("hit3");
      hit = true;
      return x1;
    }
    else if((mX+20<=x1 && mX+50>=x1 && mY<=y2 && mY+50>=y2)||(mX+20<=x1 && mX+50>=x1 && mY<=y1 && mY+50>=y1))
    {
      x1+=2;
      System.out.println("hit4");
      hit = true;
      return x1;
    }
    else
    {
      hit = false;
      return 0;
    }
  }
}