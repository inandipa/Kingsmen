package kingsmen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UndefinedFunctions {
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		String line = "";
		Matcher m;
		int line_number = 0;
		while((line = br.readLine()) != null){
			line_number++;
			
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			
		}
		br.close();
	}


}
