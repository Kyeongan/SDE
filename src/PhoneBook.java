import java.util.HashMap;
import java.util.Scanner;
// PhoneBook with HashMap

public class PhoneBook {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			map.put(name, phone);
			in.nextLine();
		}

		while (in.hasNext()) {
			String name = in.nextLine();
			Integer phonenumber = map.get(name);
			if (!map.containsKey(name)) {
				System.out.println("Not found");
			}
			else 
				System.out.println("Name:" + name + " - " + phonenumber);
		}
	}
}