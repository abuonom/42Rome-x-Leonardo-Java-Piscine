
import java.util.Scanner;

public class Program {
	static public void	main(String[] args) {
		if(args.length != 2){
			System.err.println("Insert 2 files");
			System.exit(-1);
		}
		String pathf1 = args[0];
		String pathf2 = args[1];
		Dictonary dictonary = new Dictonary(pathf1, pathf2);
		System.out.println("Similarity = " + Math.floor(dictonary.getSimilarity() * 100)  / 100);
	}
}
