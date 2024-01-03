import java.io.*;
import java.util.*;

public class Signature {
	private Map<int[], String> map = new HashMap<>();
	private int maxByte;

	public Signature(){
		this.maxByte = 0;
	}

	public boolean generateMap(){
		String filePath = "signature.txt";
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line;
			String [] signKey;
			char [] signKeyArray;
			char [] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B','C','D','E','F'};
			ArrayList<Integer> valuesList = new ArrayList<>();
			int[] valuesArray;
			int temp;
			while ((line = br.readLine()) != null) {
			 signKey = line.split(", ");
				if (signKey.length != 2){
					throw new SplitErrorException("Function Split returned signKey.lenght > 2");
				}
			 	signKey[1] = signKey[1].replaceAll(" ","");
				signKeyArray = signKey[1].toCharArray();
				for(int i = 0; i < signKeyArray.length; i+=2){
					temp = 0;
					for(int x = 0; x < hex.length; x++){
						if(signKeyArray[i] == hex[x]){
							temp += x*16;
						}
					}
					for(int x = 0; x < hex.length; x++){
						if(signKeyArray[i+1] == hex[x]){
							temp += x;
						}
					}
					valuesList.add(temp);
				}
				valuesArray = new int[valuesList.size()];
				for (int i = 0; i < valuesList.size(); i++) {
					valuesArray[i] = valuesList.get(i);
				}
				valuesList.clear();
				this.map.put(valuesArray, signKey[0]);
				if(this.maxByte < signKey[1].length()){
					this.maxByte = signKey[1].length();
				}
			}
			fr.close();
			br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return true;
	}

	public void generateResult(String filepath) {
		try {
			String path = "result.txt";
			InputStream inputStream = new FileInputStream(filepath);
			File file = new File(path);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			byte[] magicNumberBuffer = new byte[this.maxByte];
			int bytesRead = inputStream.read(magicNumberBuffer, 0, this.maxByte);
			boolean flag = false;

			if (bytesRead == this.maxByte) {
				for (Map.Entry<int[], String> entry : map.entrySet()) {
					int[] magicNumber = entry.getKey();
					if (isMagicNumberMatch(magicNumberBuffer, magicNumber)) {
						System.out.println("PROCESSED");
						bw.write(entry.getValue());
						bw.newLine();
						flag = true;
						break;
					}
				}
			}

			inputStream.close();
			bw.close();

			if (!flag) {
				System.out.println("UNDEFINED");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private boolean isMagicNumberMatch(byte[] magicNumberBuffer, int []magicNumber) {
		for(int i = 0; i < magicNumber.length; i++) {
			if((magicNumberBuffer[i] & 0xFF) != magicNumber[i]) {
				return false;
		}
	}
	return true;
}

	public void		printMap() {
		String type;

		for (int	key[] : this.map.keySet()) {
			for (int i = 0; i < key.length; i++) {
				System.out.printf(key[i] + " ");
			}
			System.out.print(": ");
			type = this.map.get(key);
			System.out.print(type);
			System.out.println();
		}
		System.out.println("Lunghezza massima in byte: " + this.maxByte);
	}
}
