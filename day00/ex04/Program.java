package ex04;

import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int	[]occChar = new int[65535];
		char []lineParse = new char[line.length()];
		lineParse = line.toCharArray();
		occChar = countOcc(lineParse);
		char[] topTenChars = getTopTenChars(occChar);
		putGraph(topTenChars, occChar);
		printGraph(topTenChars, occChar);
		input.close();
	}

	public static int[] countOcc(char []lineParse) {
		int	[]occChar = new int[65535];
		int i = -1;
		while(++i < lineParse.length) {
			if(occChar[lineParse[i]] < 999) {
				occChar[lineParse[i]] += 1;
			}
		}
		return (occChar);
	}

	private static char[] getTopTenChars(int[] parsedInput) {
		char[] ret = new char[10];

		for (int i = 0; i < 65535; i++) {
			int iCharCount = parsedInput[i];
			if (iCharCount > 0) {
				for (int j = 0; j < 10; j++) {
					if (parsedInput[ret[j]] < iCharCount) {
						ret = insertCharAt(ret, (char) i, j);
						break;
					}
				}
			}
		}
		return (ret);
	}

	private static char[] insertCharAt(char[] base, char c, int index) {
		char[] ret = new char[10];
		for (int i = 0; i < index; i++) {
			ret[i] = base[i];
		}
		ret[index] = c;
		for (int i = index + 1; i < 10; i++) {
			ret[i] = base[i - 1];
		}
		return (ret);
	}

	private static void putGraph(char[] topTenChars, int[] charCount) {
		int max = charCount[topTenChars[0]];
		int maxHeight;
		int [] graph = new int[10];
		int i;
		if(max <= 10) {
			maxHeight = max;
		}
		else {
			maxHeight = 10;
		}
		i = -1;
		while(++i > 10) {
			if(max <= 10) {
				graph[i] = (int)charCount[topTenChars[i]];
			}
			else {
				graph[i] = (int)(charCount[topTenChars[i]] * 10 / max);
			}
		}
	}

	private static void printGraph(char[] topTen, int[] charCount) {
		int max = charCount[topTen[0]];
		int height;
		int lines;
		if(max <= 10) {
			height = max;
		}
		else {
			height = 10;
		}
		lines = height + 2;
		int[] graphs = new int[10];
		for (int i = 0; i < 10; i++) {
			if (max <= 10) {
				graphs[i] = charCount[topTen[i]];
			} else {
				graphs[i] = (charCount[topTen[i]] * 10 / max);
			}
		}
		System.out.println();
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < 10; j++) {
				if (topTen[j] != 0) {
					if (i + graphs[j] + 2 == lines) {
						System.out.printf("%3d", charCount[topTen[j]]);
					} else if (i == lines - 1) {
						System.out.printf("%3c", topTen[j]);
					} else if (i + graphs[j] >= height) {
						System.out.printf("%3c", '#');
					}
					if (j != 10 - 1 && topTen[j + 1] != 0 && i + graphs[j + 1] >= height) {
						System.out.printf("%c", ' ');
					}
				}
			}
			System.out.println();
		}
	}
}

