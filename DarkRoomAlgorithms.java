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
		int[][] pixelArray = source.getPixelArray();
		int[] histogram = computeHistogram(pixelArray);
		int[] cumulativeHistogram = computeCumulativeHistogram(histogram);
		equalizeImage(pixelArray, cumulativeHistogram);

		return new GImage(pixelArray);
	}

	private int[] computeHistogram(int[][] pixels) {
		int height = pixels.length;
		int width = pixels[0].length;

		int[] histogram = new int[256];

		// Fill in the histogram using all the pixel's luminosities
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				int pixel = pixels[row][col];
				int red = GImage.getRed(pixel);
				int green = GImage.getGreen(pixel);
				int blue = GImage.getBlue(pixel);
				int luminosity = computeLuminosity(red, green, blue);

				histogram[luminosity]++;
			}
		}

		return histogram;
	}

	private int[] computeCumulativeHistogram(int[] histogram) {
		int[] cumulativeHistogram = new int[histogram.length];

		// Index i in the cumulative histogram is the number of pixels
		// with AT MOST luminosity i.
		int total = 0;
		for (int i = 0; i < histogram.length; i++) {
			total += histogram[i];
			cumulativeHistogram[i] = total;
		}

		return cumulativeHistogram;
	}

	private void equalizeImage(int[][] array, int[] cumulativeHistogram) {
		// Replace each luminosity value with 255 * cumulative histogram[L] / total #
		// pixels
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[0].length; col++) {
					int pixel = array[row][col];
					int red = GImage.getRed(pixel);
					int green = GImage.getGreen(pixel);
					int blue = GImage.getBlue(pixel);
					int luminosity = computeLuminosity(red, green, blue);

					int newLuminosity = (int) (255 * cumulativeHistogram[luminosity] / (array.length * array[0].length));
					array[row][col] = GImage.createRGBPixel(newLuminosity, newLuminosity, newLuminosity);
			}
		}
	}
	
	public GImage negative(GImage source) {
		int[][] pixelArray = source.getPixelArray();  
		for (int r = 0; r < pixelArray.length; r++) {
			for(int c = 0; c < pixelArray[0].length; c++) {
				int pixel = pixelArray[r][c];
				int redValue = GImage.getRed(pixel);
				int greenValue = GImage.getGreen(pixel);
				int blueValue = GImage.getBlue(pixel);
				int newRed = Math.abs(255 - redValue);
				int newGreen = Math.abs(255 - greenValue);
				int newBlue = Math.abs(255 - blueValue);
				int newPixel = GImage.createRGBPixel(newRed, newGreen, newBlue);
				pixelArray[r][c] = newPixel;
			}
		}
		GImage image = new GImage(pixelArray); 
		return image;
	}


	public GImage crop(GImage source, int cropX, int cropY, int cropWidth, int cropHeight) {
		int[][] pixelArray = source.getPixelArray();
		int[][] croppedArray = new int[cropHeight][(int) cropWidth];
		for (int r = 0; r < croppedArray.length; r++) {
			for (int c = 0; c < croppedArray[0].length; c++) {
				croppedArray[r][c] = pixelArray[(r + cropX)][(c + cropY)];
			}
		}
		return new GImage(croppedArray);
	}

	public GImage scale(GImage source, double scaleFactor) {
		int[][] originalPixelArray = source.getPixelArray();
		int height = originalPixelArray.length;
		int width = originalPixelArray[0].length;
		int newHeight = (int) (height * scaleFactor);
		int newWidth = (int) (width * scaleFactor);
		int[][] newPixelArray = new int[newHeight][newWidth];

		for (int r = 0; r < newPixelArray.length; r++) {
			for (int c = 0; c < newPixelArray[0].length; c++) {
				int color = originalPixelArray[(int) (r / (double) newHeight * height)][(int) (c / (double) newWidth
						* width)];
				newPixelArray[r][c] = color;
			}
		}
		return new GImage(newPixelArray);
	}
}
