import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListApp {

	public static void main(String[] args) {
		// ArrayList manages arrays
		List<Integer> arrayList = new ArrayList<Integer>();
		
		// LinkedList is a double linked list which has a reference to previous and next elements
		List<Integer> linkedList = new LinkedList<Integer>();
		
		doTiming("ArrayList", arrayList);
		doTiming("LinkedList", linkedList);

	}

	private static void doTiming(String text, List<Integer> list) {
		
		long startTime = System.currentTimeMillis();
		
		// Populate
		for(int i = 0; i<1E4 ; i++) {
			list.add(i);
		}
		
		for(int i=0; i<5 ; i++) {
			System.out.println("Values : " + list.get(i));
		}
		
		for(int i = 0; i<1E4 ; i++) {
			list.add(0, i);
		}
		
		for(int i=0; i<5 ; i++) {
			System.out.println("Values : " + list.get(i));
		}
		
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (endTime-startTime) + " ms for " + text);
		
	}

}
