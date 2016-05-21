package edu.uh.cs.sde;

import java.util.Scanner;

public class SumOfInteger {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Input N: ");
		int n = sc.nextInt();
		int sum = 0;

		int[] a = new int[n];

		for (int t = 0; t < n; t++) {

			a[t] = sc.nextInt();
		}

		for (int i = 0; i < a.length; i++) {
			sum += a[i];

		}
		System.out.println("Sum of inputs is " + sum);
	}

}
