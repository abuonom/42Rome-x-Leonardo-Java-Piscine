package edu.school21.printer.app;
import edu.school21.printer.logic.Image;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Program {
	static String path;
	static char white;
	static char black;
	public static void main(String args[]){
		if(args.length != 3){
			System.err.println("Add the path and the character");
			System.exit(-1);
		}
		try{
			path = args[0];
			white = args[1].toCharArray()[0];
			black = args[2].toCharArray()[0];
			File file = new File(path);
			BufferedImage image = ImageIO.read(file);
			Image imageAscii = new Image(image,white,black);
			imageAscii.printImage();
		}catch(IOException e){
			System.out.println("IO error");
			System.exit(-1);
		}
	}
}
