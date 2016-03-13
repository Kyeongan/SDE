import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapApp {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		// HashMap - no guarantee the order even if sometimes show it by ordering.
		testMap(hashMap);
		
		// LinkedHashMap - order by input
		testMap(linkedHashMap);
		
		// TreeMap - natural order by key
		testMap(treeMap);
		

	}
	
	private static void testMap(Map<Integer, String> map ) {
		map.put(9, "Nine");
		map.put(0, "Zero");
		map.put(5, "Five");
		map.put(3, "Three");
		map.put(2, "Two");
		map.put(7, "Seven");
		
		for (Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
	}

}
