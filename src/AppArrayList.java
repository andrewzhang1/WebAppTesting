

import java.util.ArrayList;
import java.util.List;

public class AppArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(10);
		numbers.add(100);
		numbers.add(1000);

		System.out.println("\nInteration #1:");
		System.out.println(numbers.get(0));
		for (int i =0; i < numbers.size(); i++){
			System.out.println(numbers.get(i));
		}
		
		// another way to iteration
		System.out.println("\nInteration #2:");
		for(Integer value: numbers){
			System.out.println(value);
		}
		
		// Remove items (careful!)
		numbers.remove(numbers.size() - 2 );
		System.out.println("\nHow to remove:");
		System.out.println("\nafter remove (1):");
	//	numbers.remove(1);
		
		for(Integer value: numbers){
			System.out.println(value);
		}
	
		// Collection are grouped by interfaces
		List<String> values = new ArrayList<String>();
		
	}

}
