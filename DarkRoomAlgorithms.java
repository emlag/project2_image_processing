/* 
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 * 
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

// TODO: comment this file explaining its behavior

import java.util.*;
import acm.graphics.*;

public class DarkRoomAlgorithms implements DarkRoomAlgorithmsInterface {

	public GImage flipHorizontal(GImage source) {
		int[][] pixelArray = source.getPixelArray();
		int width = pixelArray[0].length;
		for (int col1 = 0; col1 < width/2; col1++) {
			int col2 = width - col1 - 1;
			for (int row = 0; row < pixelArray.length; row++) {
				int temp = pixelArray[row][col1];
				pixelArray[row][col1] = pixelArray[row][col2];
				pixelArray[row][col2] = temp;
			}
		}
		return new GImage(pixelArray);
	}

	public GImage rotateLeft(GImage source) {
		int[][] pixelArray = source.getPixelArray();
		int height = pixelArray.length;
		int width = pixelArray[0].length;

		int[][] newImageArray = new int[width][height];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				newImageArray[width - col - 1][row] = pixelArray[row][col];
			}
		}
		return new GImage(newImageArray);
	}

	public GImage rotateRight(GImage source) {
		// TODO
		return rotateLeft(rotateLeft(rotateLeft(source)));
	}

	public GImage greenScreen(GImage source) {
		// TODO
		return null;
	}

	public GImage equalize(GImage source) {
		// TODO
		return null;
	}

	public GImage negative(GImage source) {
		// TODO
		return null;
	}

	public GImage crop(GImage source, int cropX, int cropY, int cropWidth, int cropHeight) {
		// TODO
		return null;
	}

	public GImage scale(GImage source, double scaleFactor) {
		// TODO
		return null;
	}
}
