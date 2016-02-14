package game;

import canvas.Canvas;
import java.util.*;
import java.awt.Graphics2D;

public class GameRunner{
	static GameCanvas canvas;
	static int frameCount = 0;
	static ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	public static void main(String[] args) throws Exception{
		canvas = new GameCanvas();
		Sprite smiley = new Sprite();
		sprites.add(smiley);
	}
	public static void tick(Graphics2D g){
		frameCount++;
		for(Sprite sprite : sprites){
			sprite.tick();
		}
		canvas.rebound(g,sprites);
	}
}