package sort;
import java.util.*;

public class ComparableSorter{
	
	public static Comparable[] selectionSort(Comparable[] array){
		for(int i = 0; i < array.length; i++){
			
			Comparable held = array[i];
			
			Comparable minimum = array[i];
			int minimumIndex = i;
			
			for(int j = i+1; j<array.length; j++){
				
				if(minimum.compareTo(array[j])==1){
					minimum=array[j];
					minimumIndex=j;
				}
				
			}
			
			array[i]=minimum;
			array[minimumIndex]=held;
		}
		return array;
	}
	public static void selectionSort(List<Comparable> list){
		for(int i = 0; i < list.size(); i++){
			
			Comparable held = list.get(i);
			
			Comparable minimum = list.get(i);
			int minimumIndex = i;
			
			for(int j = i+1; j<list.length; j++){
				
				if(minimum.compareTo(list.get(j))==1){
					minimum=list.get(j);
					minimumIndex=j;
				}
				
			}
			
			list.get(i)=minimum;
			list.get(minimumIndex)=held;
		}
		return list;
	}
	public static void main(String[] arguments){
		String[] array = {"Meep!", "meep!", "beep!", "Beep!"};
		selectionSort(array);
		
	}
	
}