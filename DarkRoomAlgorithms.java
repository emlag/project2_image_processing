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
            int[][] array = source.getPixelArray();
            int width = array[0].length;
            for col1 = 0 to width / 2:
                col2 = width - col1 - 1.
                for row = 0 to pixels.length:
                     temp = array[row][col1].
                     array[row][col1] = array[row][col2].
                     array[row][col2] = temp.
            return new GImage(array).
	}

	public GImage rotateLeft(GImage source) {
		// TODO
		return null;
	}

	public GImage rotateRight(GImage source) {
		// TODO
		return null;
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
