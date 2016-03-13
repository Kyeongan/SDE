import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class Person {
	private int id;
	private String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return id + ": " + name;
	}
}

public class MapSetApp {

	public static void main(String[] args) {
		
		Person p1 = new Person(0, "Bob");
		Person p2 = new Person(1, "Sue");
		Person p3 = new Person(2, "Mike");
		Person p4 = new Person(1, "Sue");	// duplicated 
		
		Map <Integer, Person> map = new HashMap<Integer, Person>();
		
		map.put(0, p1);
		map.put(1, p2);
		map.put(2, p3);
		map.put(3, p4);

		
		
		for (Integer key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		
		// Set
		Set<Person> set = new LinkedHashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		System.out.println(set);
		

	}

}
