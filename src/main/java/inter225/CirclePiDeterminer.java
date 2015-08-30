package inter225;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// Given an image representation of a circle, estimate the value of pi
public class CirclePiDeterminer {

	static double determinePiFromImage(BufferedImage circle) {
		long numberOfBlackPixels = 0;
		int leftMostX = -1;
		int rightMostX = -1;
		
		for(int x = 0; x < circle.getWidth(); x++) {
			for(int y = 0; y < circle.getHeight(); y++) {
				if (circle.getRGB(x, y) != -1) {
					numberOfBlackPixels += 1;
					if (leftMostX == -1) {
						leftMostX = x;
					} else if (leftMostX > x) {
						leftMostX = x;
					}
					
					if (rightMostX == -1) {
						rightMostX = x;
					} else if (rightMostX < x) {
						rightMostX = x;
					}
					
				}
			}
		}		
	
		// area = pi * r^2
		// pi = area / r^2
		int radius = (int)((rightMostX - leftMostX + 1) / 2);
		return (double)((double)numberOfBlackPixels / (double)(radius * radius));
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(CirclePiDeterminer.determinePiFromImage(ImageIO.read(new File("little_circle.png"))));
		System.out.println(CirclePiDeterminer.determinePiFromImage(ImageIO.read(new File("medium_circle.png"))));
		System.out.println(CirclePiDeterminer.determinePiFromImage(ImageIO.read(new File("massive_circle.png"))));
	}
	
}

