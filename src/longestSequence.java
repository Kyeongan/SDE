//Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array

public class longestSequence {

	
	static int maxOnesIndex(int arr[], int n)
	{
		int max_count = 0; // for maximum number of 1 around a zero
		int max_index=0; // for storing result
		int prev_zero = -1; // index of previous zero
		int prev_prev_zero = -1; // index of previous to previous zero

		// Traverse the input array
		for (int curr=0; curr<n; ++curr)
		{
			// If current element is 0, then calculate the difference
			// between curr and prev_prev_zero
			if (arr[curr] == 0)
			{
				// Update result if count of 1s around prev_zero is more
				if (curr - prev_prev_zero > max_count)
				{
					max_count = curr - prev_prev_zero;
					max_index = prev_zero;
				}

				// Update for next iteration
				prev_prev_zero = prev_zero;
				prev_zero = curr;
			}
		}

		// Check for the last encountered zero
		if (n-prev_prev_zero > max_count)
			max_index = prev_zero;

		return max_index;
	}

	public static int findLongestSequence(int[] array, int k) {
		int maxLength = 0;
		int start = 0;
		int runningLength = 0;
		int tmpK = k;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				runningLength++;
			} else if (tmpK > 0 && tmpK < k) {
				tmpK--;
				runningLength++;
			} else if (tmpK == k) {
				tmpK--;
				runningLength++;
				start = i;
			} else { // tmpK == 0
				tmpK = k;
				maxLength = Math.max(maxLength, runningLength);
				runningLength = 0;
				int tmp = i;
				i = start;
				start = tmp;
			}
		}

		return Math.max(maxLength, runningLength);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int k = 2;
		int n = ar.length;
		System.out.print("Longest Sequence is " + maxOnesIndex(ar, n));

	}
}
