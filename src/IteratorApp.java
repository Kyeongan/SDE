import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorApp {

	public static void main(String[] args) {
		
		List <String> animals = new LinkedList<String>();
		
		animals.add("Rabbit");
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Fox");
		
		Iterator<String> it1 = animals.iterator();
		while(it1.hasNext()) {
			String val = it1.next();
			System.out.println(val);
		}
		System.out.println();
		
		ListIterator<String> it = animals.listIterator();
		while(it.hasNext()) {
			String value = it.next();
			if(value.equals("Cat")) 
				it.remove();
			if(value.equals("Fox"))
				it.add("Fox2");	// If need to add items, ListIterator needed
				
			
			System.out.println(value);
		}
		
		System.out.println();
		
		// Modern iteration, Java 5 and later
		for (String animal : animals) {
			System.out.println(animal);
//			animals.remove(2);	--> this doesn't allow. You should use Iterator
		}

	}

}
