
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {
			boolean fizz = (i % 3) == 0;
			boolean buzz = (i % 5) == 0;

			if (fizz && buzz) {
				System.out.println("fizzbuzz");
			} else if (fizz) {
				System.out.println("fizz");
			} else if (buzz) {
				System.out.println("buzz");
			} else {
				System.out.println
				(i);
			}

		}
	}
}
