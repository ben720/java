package canvas.wave;

import java.awt.Color;
import java.awt.Graphics2D;
import canvas.*;

public class WavyThing {
	public static void main(String[] args) {
		final int width = 941;
		final int interval = 20;
		new Canvas("Wavy thing",width,401){
			private int count;
			private static final long serialVersionUID = -129387123L;

			public void paint(Graphics2D g){
				count++;
				g.drawLine(0, 200, width, 200);
				for(int i = 0; i < width; i+=1){
					g.setColor(Color.BLACK);
					g.drawRect((i+i%interval), 
							(int) (200+200*Math.sin((count-i)/50.0)), 1, 1);
					g.setColor(new Color(150,150,150));
					g.drawRect((i)%width, (int) (200+200*Math.cos(count+i)), 1, 1);
				}
			}
		};
	}
}
