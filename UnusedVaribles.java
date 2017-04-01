import java.io.*;

public class UnusedVaribles {
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		String line = "";
		while((line = br.readLine()) != null){
			System.out.println(line);
			
		}
		br.close();
	}

}
