package game;

import canvas.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.*;
import java.util.*;

public class GameCanvas extends Canvas{
	GameCanvas(){
		super("Game",33,1024,768);
	}
	public void paint(Graphics2D g){
		GameRunner.tick(g);
		g.drawLine(100,GameRunner.frameCount,
			GameRunner.frameCount,100);
	}
	public void rebound(Graphics2D g, ArrayList<Sprite> sprites){
		for(Sprite sprite : sprites){
			g.drawImage(sprite.getCurrentFrame(),sprite.x,sprite.y,null);
		}
	}
}