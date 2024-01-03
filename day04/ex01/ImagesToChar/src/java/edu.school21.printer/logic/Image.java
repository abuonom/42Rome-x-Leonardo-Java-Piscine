package target.edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class Image {
	private BufferedImage image;
	private int height;
	private int width;
	private int maxPixelValue = 255;
	private char white;
	private char black;

	public Image(BufferedImage image, char white, char black){
		this.image = image;
		this.height = image.getHeight();
		this.width = image.getWidth();
		this.white = white;
		this.black = black;
	}

	public void printImage(){
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int pixelColor = image.getRGB(x, y);
				int grayscaleValue = pixelColor & 0xFF;
				if (grayscaleValue == 0) {
					System.out.print(black);
				} else if (grayscaleValue == maxPixelValue) {
					System.out.print(white);
				} else {
					System.out.print("?");
				}
			}
			System.out.println("");
		}
	}
}
