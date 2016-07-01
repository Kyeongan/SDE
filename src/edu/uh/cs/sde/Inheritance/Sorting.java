package edu.uh.cs.sde.Inheritance;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,40,50,30,20,30,50,60,40};
		bubbleSort(arr);

	}
	
	public static void bubbleSort(int[] num) {
		boolean flag = true;
		int j = 0;
		int temp;
		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) // change to > for ascending sort
				{
					temp = num[j]; // swap elements
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}

}
