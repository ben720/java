package questions;
//Answers:
//8: B
//9: C 
public class Questions8And9{
	public static void question8(){
		TimeRecord record = new TimeRecord(3,59);
		record.advance(0,2);
		System.out.println("Question 8: \r\n");
		System.out.println("Hours: ");
		System.out.println(record.getHours());
		System.out.println("Minutes: ");
		System.out.println(record.getMinutes());
	}
	public static void question9(){
		TimeRecord[] timeCards = new TimeRecord[100];
		for(int i = 0; i < 100; i++){
			timeCards[i]=new TimeRecord(i,31);
		}
		TimeRecord total = new TimeRecord(0,0);
		for(int k = 0; k < timeCards.length; k++){
			//C
			total.advance(timeCards[k].getHours(),
				timeCards[k].getMinutes());
		}
		System.out.println("\r\nQuestion 9:\r\n");
		System.out.println("Hours:");
		System.out.println(total.getHours());
		System.out.println("Minutes:");
		System.out.println(total.getMinutes());
	}
	public static void main(String[] args){
		question8();
		question9();
	}
}
class TimeRecord{
	private int hours;
	private int minutes; // 0<= minutes < 60
	/** Constructs a TimeRecord object
	* @param h the number of hours
	*	Preconditon: h>=0
	* @param m the number of minutes
	*	Preconditon: 0<=m<=60 
	*/
	public TimeRecord(int h, int m){
		hours = h; 
		minutes = m;
	}
	/** @return the number of hours
	*/
	public int getHours(){
		/* implementation not shown */
		return hours;
	}
	/**
	* @return the number of minutes
	* Postcondition: 0<=minutes<60
	*/
	public int getMinutes(){
		/*implementation not shown*/
		return minutes;
	}
	/** Adds h hours and m minutes to this TimeRecord
	* @param h the number of hours
	*	Precondition h>=0
	* @param m the number of minutes
	*	Precondition m>=0
	*/
	public void advance(int h, int m){
		hours=hours+h;
		minutes=minutes+m;
		/* missing code */
		//B
		hours=hours+minutes/60;
		minutes=minutes%60;
	}
	//Other methods not found
}