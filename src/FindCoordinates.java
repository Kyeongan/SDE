// Imagine we have an image where every pixel is white or black.  We’ll represent this image as a simple 2D array (0 = black, 1 = white).  The image you get is known to have a single black rectangle on a white background.  Your goal is to find this rectangle and return its coordinates.

// Here’s a sample “image” using JavaScript (feel free to rewrite in your language of choice):

// var image = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 1, 1, 1, 1, 1, 1]
// ];

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class FindCoordinates {

	public static void main(String[] args) {
		int[][] image = new int[][]{
		      { 1, 1, 1, 1, 1, 1, 1 },
		      { 1, 1, 1, 1, 1, 1, 1 },
		      { 1, 1, 1, 0, 0, 0, 1 },
		      { 1, 1, 1, 0, 0, 0, 1 },
		      { 1, 1, 1, 1, 1, 1, 1 }
		    };
		coordiate(image);
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
			for (int j = 0; j < image[i].length; j++) { // col

				if (image[i][j] == 0) { // first 0
					if (firstBlack == false) {
						x1 = j;
						y1 = i;
						firstBlack = true;
					}
					x2 = j;
					y2 = i;
				}
				// if(image[i][j] != 0)

				// if(firstBlack = true && image[i][j] == 1) {
				// x2 = i--;
				// }

			}

		}

		System.out.println("x1:" + x1 + " y1:" + y1 + ", x2:" + x2 + " y2:" + y2);

		// (3,2), (5, 3)
	}
}

/*
 * Your previous Markdown content is preserved below:
 * 
 * Welcome to the Interview!
 */