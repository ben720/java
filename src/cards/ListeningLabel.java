package cards;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
/**
* ListeningLabel. One of the "buttons." Has a reference to the Board it's part of.
* Also has a reference to a labelMouseAdapter, which controls activity. The board determines whether or not this
* label is selected.
*/
public class ListeningLabel extends JLabel{
	/** Reference to the board this is part of.*/
	Board board;
	/** The mouse handler that controls this. */
	LabelMouseAdapter labelMouseAdapter;
	ListeningLabel(String text, Board board, int index, int position){
		super(text, position);
		labelMouseAdapter=new LabelMouseAdapter(index, board, this);
		addMouseListener(labelMouseAdapter);
	}
}