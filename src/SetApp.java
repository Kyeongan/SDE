import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SetApp {

	public static void main(String[] args) {
		
		Map <Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Alice");
		map.put(2, "Bob");
		map.put(3, "Clare");
		map.put(4, "David");
		map.put(5, "David");
		map.put(6, "David");

		System.out.println(map);
		
//		for (String key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//		}
		
		System.out.println();
		
		// Set
		Set<String> set = new HashSet<String>();
		Set<String> set2 = new LinkedHashSet<String>();
		
		set.add("Alice");
		set.add("Bob");
		set.add("Clare");
		set.add("David");
		set.add("David");
		set.add("David");
		
		System.out.println(set);
		
		set2.add("Alice");
		set2.add("Bob");
		set2.add("Clare");
		set2.add("David");
		set2.add("Karl");
		
		System.out.println(set2);
		
		set2.retainAll(set);
		System.out.println(set2);

	}

}
