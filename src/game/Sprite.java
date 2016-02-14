package game;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.*;

public class Sprite{
	private BufferedImage[] frames;
	private int currentFrameIndex = 0;
	public int x;
	public int y;
	
	public Sprite() throws IOException{
		frames = new BufferedImage[1];
		frames[0]=ImageIO.read(
			new File("resources/images/game/smiley.png"));
		x=100;
		y=100;
	}
	public BufferedImage getCurrentFrame(){
		return frames[currentFrameIndex];
	}
	public void tick(){
		
	}
}