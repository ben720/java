package canvas;

import java.awt.Graphics2D;

public class CanvasTester {
	public static void main(String[] args){
		new Canvas("",17,400,400){
			private int count=0;
			public void paint(Graphics2D g){
				count++;
				g.drawLine(100, (int)(Math.sin(count/200.0)*200+200), 300, (int)(Math.sin(count/200.0+2)*200+200));
			}
		};
	} 
}