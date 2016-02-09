package canvas;

import java.awt.Graphics2D;
import java.util.EventListener;

public interface Painter extends EventListener{
	public abstract void paint(Graphics2D g);
}
