import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

class AlpahbeticalComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		return arg0.compareTo(arg1);
	}
	
}

class ReversedAlpahbeticalComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		return -arg0.compareTo(arg1);	// negative signed allows reversed sorting
	}
	
}

public class ListApp2 {

	public static void main(String[] args) {
		List<String> animals = new ArrayList<String>();

		animals.add("Tiger");
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Snake");

		Collections.sort(animals, new AlpahbeticalComparator());
		Collections.sort(animals, new ReversedAlpahbeticalComparator());

		for (String animal : animals) {
			System.out.println(animal);
		}
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(50);
		numbers.add(20);
		numbers.add(40);
		numbers.add(70);
		numbers.add(1);
		
		Collections.sort(numbers);
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
		// Reversed ordering
		Collections.sort(numbers, new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return -num1.compareTo(num2);
			}
		});
		
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person(1, "Joe"));
		people.add(new Person(3, "Bob"));
		people.add(new Person(4, "Clare"));
		people.add(new Person(2, "Sue"));
		
		for(Person person: people) {
			System.out.println(person);
		}
		
		Collections.sort(people, new Comparator<Person>() {

			public int compare(Person p1, Person p2) {
				if (p1.getId() > p2.getId()) {
					return 1;
				} else if (p1.getId() < p2.getId()) {
					return -1;
				}
				return 0;
			}
			
		});
		
		for(Person person: people) {
			System.out.println(person);
		}
		
	}

}

