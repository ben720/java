package canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LargeCanvas extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 6533617163667767770L;
	public final JPanel panel;
	
	public LargeCanvas(String title, JPanel panel, int delay, int width, int height){
		super(title);
		this.panel=panel;
		add(panel);
		setSize(width,height);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		new Timer(delay, this).start();
	}
	public LargeCanvas(String title, JPanel panel, int delay){
		this(title, panel, delay, 1000, 800);
	}
	public LargeCanvas(String title, JPanel panel, int width, int height){
		this(title, panel, 30, width, height);
	}
	public LargeCanvas(String title, JPanel panel){
		this(title, panel, 1000, 800);
	}
	public LargeCanvas(String title, Painter rl){
		this(title, new CanvasPanel(rl));
	}
	public LargeCanvas(Painter rl){
		this("",rl);
	}
	public LargeCanvas(String title, Painter rl, int width, int height){
		this(title, new CanvasPanel(rl),width, height);
	}
	public void actionPerformed(ActionEvent e) {
		panel.repaint();
	}

}
