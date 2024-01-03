import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Dictonary {
	TreeMap<String, Integer> treeMap = new TreeMap<>();
	private double similarity;
	String pathf1;
	String pathf2;

	public Dictonary(String pathf1, String pathf2){
		this.pathf1 = pathf1;
		this.pathf2 = pathf2;
		}

	public double getSimilarity(){
		this.treeMap = readFromFile();
		int []vectorA = takeOccurency(pathf1);
		int []vectorB = takeOccurency(pathf2);
		this.similarity = cosineSimilarity(vectorA,vectorB);
		return this.similarity;
	}

	private int[] takeOccurency(String filepath){
		int []vector = new int[this.treeMap.size()];
		try {
			File file = new File(filepath);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String parola = scanner.next();
				vector[treeMap.get(parola)]++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vector;
	}
	public double cosineSimilarity(int []A, int[] B) {

		double numerator = 0;
		double denominator = 0;
		double normA = 0;
		double normB = 0;

		for (String key : treeMap.keySet()) {
			if (B[treeMap.get(key)] != 0 ) {
				numerator += A[treeMap.get(key)] * B[treeMap.get(key)];
			}
			normA += Math.pow(A[treeMap.get(key)], 2);
		}
		for (int value : B) {
			normB += Math.pow(value, 2);
		}
		denominator = Math.sqrt(normA) * Math.sqrt(normB);
		if(normA == normB){
			denominator = normA;
		}
		return ((numerator == 0 || denominator == 0) ? 0 : numerator / denominator);
	}

	private TreeMap<String, Integer> readFromFile() {

			TreeMap<String, Integer> treeMap = new TreeMap<>();
			int indice = 0;
			try {
				File file = new File(pathf1);
				Scanner scanner = new Scanner(file);
				while (scanner.hasNext()) {
					String parola = scanner.next();
					if (!treeMap.containsKey(parola)) {
						treeMap.put(parola, indice++);
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				File file = new File(pathf2);
				Scanner scanner = new Scanner(file);
				while (scanner.hasNext()) {
					String parola = scanner.next();
					if (!treeMap.containsKey(parola)) {
						treeMap.put(parola, indice++);
					}
					}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return treeMap;
		}

		public void printTreeMap() {
			for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				System.out.println(key + " = " + value);
			}
		}
	}
