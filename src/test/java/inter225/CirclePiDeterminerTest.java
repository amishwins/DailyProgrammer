package inter225;

import static org.junit.Assert.assertNotNull;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class CirclePiDeterminerTest {

	@Test
	public void readImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("little_circle.png")); // 3.3958
			//img = ImageIO.read(new File("medium_circle.png")); // 3.141824
			//img = ImageIO.read(new File("massive_circle.png")); // 3.14294
			// true-ish value of pi: 3.14159265...
			
		} catch (IOException e) {
			System.out.println("Something bad happened: " + e);
			System.exit(1);
		}
		
		assertNotNull(img);
		
		System.out.println(img.getHeight() + ", " + img.getWidth()); // 1000 x 1000
		System.out.println(img.getType()); // TYPE_3BYTE_BGR
		System.out.println(img.getColorModel());
		// ColorModel: #pixelBits = 24 numComponents = 3 color space = java.awt.color.ICC_ColorSpace@c46bcd4 transparency = 1 has alpha = false isAlphaPre = false

		// Don't need to do this, just interesting
		int pixel = img.getRGB(0, 0);
		System.out.println("pixel: " + pixel);
		Color color = new Color(pixel, img.isAlphaPremultiplied());
		System.out.println(color.getBlue() + " " + color.getGreen() + " " + color.getRed());

		pixel = img.getRGB(500, 500);
		System.out.println("pixel: " + pixel);
		color = new Color(pixel, img.isAlphaPremultiplied());
		System.out.println(color.getBlue() + " " + color.getGreen() + " " + color.getRed());
		
		System.out.println(CirclePiDeterminer.determinePiFromImage(img));		
		
	}

}
