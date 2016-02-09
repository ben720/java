package cards;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class ElevensBoard extends Board{
	
	ElevensBoard(){
		super("Elevens",4,3,11);
	}
	protected void onSelect(int index){
		if(selectedCards.size()==2){
			if(selectedCards.get(0).valueIndex + selectedCards.get(1).valueIndex+2 /*1+1 for indeces starting from 0*/== 11 ){
				removeSelected(index);
			}else if(selectedCards.get(0).valueIndex + selectedCards.get(1).valueIndex<=20){
				deselect(index);
			}
		}else if (selectedCards.size()==3){
			int[] cardValues = new int[3];
			int total = 0;
			for(int i = 0; i < 3; i++){
				cardValues[i]=selectedCards.get(i).valueIndex+1;
				total+=cardValues[i];
			}
			for(int i = 0; i < 3; i++){
				if(cardValues[i]==cardValues[(i+1)%3]){
					deselect(index);
					return;
				}
			}
			removeSelected(index);
		}
	}
	public static void main(String[] args){
		new ElevensBoard();
	}
}