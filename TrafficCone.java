import java.awt.*;

public class TrafficCone {

 private Polygon mTriangleBase;
 private Polygon mStripe;
 
 private boolean mHit;

 private int mX;
 private int mY;

 TrafficCone(int x, int y){
  mX = x; mY = y;
  mHit = false;
  setPolygons(mHit);
 }
 
 private void setPolygons(boolean hit){
   if (hit) {
     mTriangleBase = new Polygon(
       new int[]{mX, mX+35, mX},
       new int[]{mY, mY+15, mY+30},
       3);
     mStripe = new Polygon(
       new int[]{mX+7, mX+14, mX+14, mX+7},
       new int[]{mY+3, mY+6, mY+24, mY+27},
       4);
   } else {
     mTriangleBase = new Polygon(
       new int[]{mX, mX+15, mX+30},
       new int[]{mY+35, mY, mY+35},
       3);
     mStripe = new Polygon(
       new int[]{mX+3, mX+6, mX+24, mX+27},
       new int[]{mY+28, mY+21, mY+21, mY+28},
       4);
   }
 }
 public void knockOver()
 {
   if(!mHit)
   {
     mHit = true;
     setPolygons(mHit);
   }
 }
 public boolean didHit(int x1,int y1,int x2,int y2)
 {
   if(mHit)
   {
     return true;
   }
   if((mX<x1 && mX+30>x1 && mY<y1 && mY+35>y1)||
      (mX<x2 && mX+30>x2 && mY<y2 && mY+35>y2)||
      (mX<x2 && mX+30>x2 && mY<y1 && mY+35>y1)||
      (mX<x1 && mX+30>x1 && mY<y2 && mY+35>y2)||
      (mX>x1 && mX<x2 && mY>y1 && mY<y2)||
      (mX+30>x1 && mX+30<x2 && mY+35>y1 && mY+35<y2))
   {
     return true;
   }
   else
   {
     return false;
   }
 }

 public void draw (Graphics g){
  g.setColor(Color.ORANGE);
  g.fillPolygon(mTriangleBase);
  g.setColor(Color.WHITE);
  g.fillPolygon(mStripe);
 }
}