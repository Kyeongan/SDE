
public class FizzBuzz {

	public static void main(String[] args) {
		
		printFizzBuzz(100);
	}
	
	public static void printFizzBuzz(int number) {
		if (number == 0)
			System.out.println("Number is zero, There are no outputs");
		else {
			for (int i = 1; i < number; i++) {
				boolean fizz = (i % 3) == 0;
				boolean buzz = (i % 5) == 0;

				if (fizz && buzz) {
					System.out.println("fizzbuzz ");
				} else if (fizz) {
					System.out.print("fizz ");
				} else if (buzz) {
					System.out.print("buzz ");
				} else {
					System.out.print(i + " ");
				}
			}
		}
	}
}