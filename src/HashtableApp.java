import java.util.HashMap;
import java.util.Hashtable;

public class HashtableApp {

	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put("c", "Carl");
		table.put("a", "alice");
		table.put("b", "Bob");
		
		
		System.out.println(table);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("c", "Carl");
		map.put("a", "alice");
		map.put("b", "Bob");
		
		
		System.out.println(map);
	}

}
