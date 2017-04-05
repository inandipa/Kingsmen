
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraBrackets {

	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern bracket_end_pattern = Pattern.compile("\\}");
		Pattern bracket_start_pattern = Pattern.compile("\\{");
		String line = "";
		int line_number = 0;
		Matcher m;
		int bracket_count = 0;
		while((line = br.readLine()) != null){
			line_number++;
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			
			 m = bracket_start_pattern.matcher(line);
			 while (m.find( )) {
				 //System.out.println(line + " "+"in");
				bracket_count++;
			 } 

			 m = bracket_end_pattern.matcher(line);
			while(m.find( )) {
				 //System.out.println(line + " dec");
				bracket_count--;
			 }
			 
		}
		br.close();
		if(bracket_count < 0){
			System.out.println("the file has"+ Math.abs(bracket_count)+ "extra close bracket");
			
		}else if(bracket_count > 0){
			System.out.println("the file has"+ Math.abs(bracket_count)+ "extra open bracket");
		}else{
			System.out.println("the file don't have any extra brackets");
		}
		
	}


}

