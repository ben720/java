package cards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* Manager for mouse events.
*/
public class LabelMouseAdapter extends MouseAdapter{

	final static Color GRAY			= new Color(230,230,230);
	final static Color BRIGHT_YELLOW= new Color(255,255,0);
	final static Color YELLOW 		= new Color(255,255,100);
	int index;
	Board board;
	JLabel leader;
	boolean selected = false;

	public LabelMouseAdapter(int index, Board board, JLabel leader){
		super();
		this.index=index;
		this.board=board;
		this.leader=leader;
	}
	public void mouseClicked(MouseEvent e){
		board.click(index);
	}
	public void mouseEntered(MouseEvent e){
		leader.setBackground(selected?BRIGHT_YELLOW:GRAY);
	}
	public void mouseExited(MouseEvent e){
		leader.setBackground(selected?YELLOW:Color.WHITE);
	}
	public void select(boolean mouseIsIn){
		selected=true;
		if(mouseIsIn){
			leader.setBackground(BRIGHT_YELLOW);
		}else{
			leader.setBackground(YELLOW);
		}
	}
	public void deselect(boolean mouseIsIn){
		selected=false;
		if(mouseIsIn){
			leader.setBackground(GRAY);
		}else{
			leader.setBackground(Color.WHITE);
		}
	}
}