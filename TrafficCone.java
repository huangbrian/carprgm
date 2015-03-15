import java.awt.*;

public class TrafficCone {

	private Polygon mTriangleBase;
	private Polygon mStripe;

	private int mX;
	private int mY;

	TrafficCone(int x, int y){
		mX = x; mY = y;
		mTriangleBase = new Polygon(
			new int[]{mX, mX+15, mX+30},
			new int[]{mY+35, mY, mY+35},
			3);
		mStripe = new Polygon(
			new int[]{mX+3, mX+6, mX+24, mX+27},
			new int[]{mY+28, mY+21, mY+21, mY+28},
			4);
	}

	public void draw (Graphics g){
		g.setColor(Color.ORANGE);
		g.fillPolygon(mTriangleBase);
		g.setColor(Color.WHITE);
		g.fillPolygon(mStripe);
	}
}