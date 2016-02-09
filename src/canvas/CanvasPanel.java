package canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CanvasPanel extends JPanel {

	private static final long serialVersionUID = -720232615366101146L;
	
	Painter rl;
	
	public CanvasPanel(Painter rl){
		super();
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.rl=rl;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		rl.paint((Graphics2D)g);
	}
}
