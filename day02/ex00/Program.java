
import java.util.Scanner;

public class Program {
	static public void	main(String args[]) {
		Signature			signatures;
		Scanner				scanner;
		String				line;
		signatures = new Signature();
		scanner = new Scanner(System.in);
		if (!signatures.generateMap()) {
			System.exit(-1);
		}
		try {
			System.out.print("-> ");
			line = scanner.nextLine();
			while (!line.equals("42")) {
				signatures.generateResult(line);
				System.out.print("-> ");
				line = scanner.nextLine();
			}
		} catch (SplitErrorException e) {
			System.out.println(e);
			System.exit(-1);
		}
		scanner.close();
	}
}
