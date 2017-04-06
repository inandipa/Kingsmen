
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraBrackets {

	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader("/users/indra/Desktop/app.js");
		BufferedReader br = new BufferedReader(file);
		Pattern bracket_end_pattern = Pattern.compile("(\\s*)\\}");
		Pattern bracket_start_pattern = Pattern.compile("(\\s*)(.*)\\{");
		Pattern empty_line_pattern = Pattern.compile("^(\\s*)$");
		Stack<String> stack = new Stack<String>();
		String line = "";
		int line_number = 0;
		Matcher m;
		while((line = br.readLine()) != null){
			line_number++;
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			m = empty_line_pattern.matcher(line);
			 if (m.find( )) {
				continue;
			 } 
			
			m = bracket_start_pattern.matcher(line);
			 while (m.find( )) {
				stack.push("{");
			 } 

			 m = bracket_end_pattern.matcher(line);
			while(m.find( )) {
				if(stack.empty()){
					System.out.println("Source file have missing {");
				}else{
					stack.pop();
				}
			 }
			
			
		}
		br.close();
		if(!stack.empty()){
			System.out.println("Source file have missing } ");
		}
		
		
	}


}

