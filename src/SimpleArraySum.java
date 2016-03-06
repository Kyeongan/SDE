
public class SimpleArraySum {

	public void ArraySum(int array[], int size)
	{
		int sum=0;
		for(int i=0; i<size;i++)
		{
			sum = sum + array[i];
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args){
		int x[] = {1,2,3,4,10,11};
		SimpleArraySum s = new SimpleArraySum();
		s.ArraySum(x, 6);
	}
}
