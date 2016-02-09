package cards;

import java.util.ArrayList;
/**
* List of Card's.
**/
public class Cards extends ArrayList<Card>{
	final static Cards DECK=new Cards(52);
	static{
		for(int i = 0; i <52; i++){
			DECK.add(new Card(i));
		}
	}
	Cards(){
		super();
	}
	Cards(int size){
		super(size);
	}
	Cards shuffle(){
		Cards result = new Cards(size());
		Card[] section1 = new Card[size()/2];
		Card[] section2 = new Card[size()/2+size()%2];
		
		int i = 0;
		for(; i < size()/2; i++){
			section1[i]=get(i);
		}
		for(; i < size(); i++){
			section2[i-size()/2]=get(i);
		}
		for(int j = 0; j<size()/2; j++){
			Card temp = section1[j];
			int randomIndex = (int)Math.floor(Math.random()*section2.length);
			section1[j]=section2[randomIndex];
			section2[randomIndex]=temp;
		}
		for(i=0; i < size()/2; i++){
			result.add(section1[i]);
		}
		for(i=0; i < size()/2+size()%2; i++){
			result.add(section2[i]);
		}
		return result;
	}
	Cards shuffleIt(){
		Card[] section1 = new Card[size()/2];
		Card[] section2 = new Card[size()/2+size()%2];
		int size = size();
		
		int i = 0;
		for(; i < size()/2; i++){
			section1[i]=get(i);
		}
		for(; i < size(); i++){
			section2[i-size()/2]=get(i);
		}
		for(int j = 0; j<size()/2; j++){
			Card temp = section1[j];
			int randomIndex = (int)Math.floor(Math.random()*section2.length);
			section1[j]=section2[randomIndex];
			section2[randomIndex]=temp;
		}
		clear();
		for(i=0; i < size/2; i++){
			add(section1[i]);
		}
		for(i=0; i < size/2+size%2; i++){
			add(section2[i]);
		}
		return this;
	}
}