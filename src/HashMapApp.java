import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapApp {

	public static void main(String argc[]) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		
		map.put(1, "One");
		map.put(2, "Two");
		map.put(0, "Zero");
		map.put(3, "Three");
		
		System.out.println(map.get(1));
		
		for(int i=0; i<map.size() ; i++) {
			System.out.println(map.get(i));
		}

		for(Entry<Integer, String> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
