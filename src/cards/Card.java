package cards;

/**
* Immutable card. Uses standard 52-card deck.
*/
public class Card implements Cloneable{
	/** String representation of the suit. Can be "Clubs", "Diamonds", "Hearts", or "Spades". **/
	public final String suit;
	/** Can be 0:clubs, 1:diamonds, etc. **/
	public final int suitIndex;
	/** A, 2, 3, 4, 5 ... **/
	public final String value;
	/** 0:A, 1:2, 2:3, ... ,10:J,**/
	public final int valueIndex;
	/** Index. Unique for each card. 13*suitIndex+valueIndex.**/
	public final int cardIndex;
	/** String representation of value. Indexed by field valueIndex. { "A","2","3","4","5","6","7","8","9","10","J","Q","K"}. **/
	public final static String[] valueStrings={ "A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	/** HTML suit symbols. Indexed by suitIndex; 0:club symbol... **/
	public final static String[] suitHTMLStrings ={"&clubs;","&diams;","&hearts;","&spades"};
	/** Suit string representations. Final, initialized to {"Clubs","Diamonds","Hearts","Spades"}. **/
	public final static String[] suitStrings ={"Clubs","Diamonds","Hearts","Spades"};
	/**
	* Create a new card given an index from 0 - 51.
	* @param index Index of the card. Clubs are 0-12, diamonds 13-25, etc. Ace first.
	**/
	Card(int index){
		this.cardIndex=index;
		this.valueIndex=index%13;
		this.value=valueStrings[valueIndex];
		this.suitIndex = index/13;
		this.suit=suitStrings[suitIndex];
	}
	/**
	* New card given suit and value indeces.
	* @param suitIndex Index of suit. See public final field suitIndex and suitStrings.
	* @param valueIndex Index of value. See public final fields valueIndex and valueStrings.
	**/
	Card(int suitIndex, int valueIndex){
		this.suitIndex=suitIndex;
		this.valueIndex=valueIndex;
		this.suit=suitStrings[suitIndex];
		this.value=valueStrings[valueIndex];
		this.cardIndex=13*suitIndex+valueIndex;
	}
	/**
	* New card given string suit and value.
	* @param suit Can be "Clubs", "Diamonds", etc. 
	* @param value Can be "A", "2", etc.
	* @throws No error handling is required. However, may throw java.lang.IllegalArgumentException with message "Value not found." or "Suit not found."
	**/
	Card(String suit, String value){
		this.suit=suit;
		this.value=value;
		this.valueIndex=fromValue(value);
		this.suitIndex=fromSuit(suit);
		this.cardIndex=13*suitIndex+valueIndex;
	}
	int fromValue(String valueName){
		for(int i = 0; i < valueStrings.length; i++){
			if(valueStrings[i].equals(valueName)){
				return i;
			}
		}
		throw new IllegalArgumentException("Value not found.");
	}
	int fromSuit(String suit){
		switch(suit){
			case "Clubs":return 0;
			case "Diamonds":return 1;
			case "Hearts":return 2;
			case "Spades":return 3;
			default:throw new IllegalArgumentException("Suit not found.");
		}
	}
	/**
	* @return String representation. For example: A of Spades
	*/
	public String toString(){
		return value+" of "+suit;
	}
	/**
	* @return New card with the same value.
	**/
	public Card clone(){
		return new Card(cardIndex);
	}
	/**
	* Returns an HTML string representation.
	* @return HTML representation. Example: <br><code>&lt;html&gt;A&amp;spades;&lt;/html&gt;</code><br>which represents A&spades;
	*/
	public String toHTMLString(){
		return "<html>"+value+suitHTMLStrings[suitIndex]+"</html>";
	}
}