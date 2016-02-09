package canvas;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public abstract class Canvas extends JFrame implements ActionListener{
	private static final long serialVersionUID = -889640586296005040L;
	public final CanvasPanel panel;
	protected Canvas self = this;
	/**
	 * Creates a new canvas with the specified properties.
	 * @param title Title of the window
	 * @param delay Milliseconds between frames
	 * @param width Width of the window
	 * @param height Height of the window
	 */
	public Canvas(String title, int delay, int width, int height){
		super();
		this.panel=new CanvasPanel(new Painter(){
			public void paint(Graphics2D g){
				self.paint(g);
			}
		});
		add(panel);
		setSize(width,height);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		new Timer(delay, this).start();
	}
	public Canvas(String title){
		this(title, 17, 1000, 800);
	}
	public Canvas(String title, int delay){
		this(title, delay, 1000, 800);
	}
	public Canvas(String title, int width, int height){
		this(title, 17, width, height);
	}
	public Canvas(){
		this("",17,1000,800);
	}
	public abstract void paint(Graphics2D g);
	public void actionPerformed(ActionEvent e){
		panel.repaint();
	}
}
