// Imagine we have an image where every pixel is white or black. We’ll represent
// this image as a simple 2D array (0 = black, 1 = white). The image you get is
// known to have a single black rectangle on a white background. Your goal is to
// find this rectangle and return its coordinates.

// Here’s a sample “image” using JavaScript (feel free to rewrite in your
// language of choice):

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class named Solution. If you need more classes, simply define
 * them inline.
 */

class FindCoordinates {

	public static void main(String[] args) {

		int[][] image = new int[][] {
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 } };

		int[][] image2 = new int[][] {
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 } };

		int[][] image3 = new int[][] {
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0 } };

		coordiate(image);
		coordiate(image2);
		coordiate(image3);
	}

	// time complexity: O(n^2), where n is the length
	// space complexity: O(1)
	public static void coordiate(int[][] image) {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		boolean firstBlack = false;

		for (int i = 0; i < image.length; i++) { // row
			for (int j = 0; j < image[i].length; j++) { // column

				if (image[i][j] == 0) { // first 0
					if (firstBlack == false) {
						x1 = j;
						y1 = i;
						firstBlack = true;
					}
					x2 = j;
					y2 = i;
				}
			}
		}

		System.out.println("(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")");

	}
}

