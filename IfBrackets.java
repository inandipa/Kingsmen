
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfBrackets {

	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern if_wrong_pattern = Pattern.compile("if\\((.*)\\)");
		Pattern bracket_not_found_pattern = Pattern.compile("^[^{]");
		Pattern bracket_found_pattern = Pattern.compile("^\\{");
		Pattern if_correct_pattern = Pattern.compile("if\\((.*)\\)(\\s*)\\{");
		Pattern else_correct_pattern = Pattern.compile("else(.*)\\{");
		Pattern else_wrong_pattern = Pattern.compile("else");
		String line = "";
		boolean bracket_found = false;
		Matcher m;
		int line_number = 0;
		int error_occured = 0;
		while((line = br.readLine()) != null){
			line_number++;
			
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			
			if(bracket_found){
				 m = bracket_found_pattern.matcher(line); 
				 if (m.find( )) {
					 bracket_found = false;
					 //System.out.println(error_occured);
				 }
				 m = bracket_not_found_pattern.matcher(line); 
				 if (m.find( )) {
					 bracket_found = false;
					 System.out.println(error_occured);
				 }
			}else{
		
				m = if_wrong_pattern.matcher(line); 
			    if (m.find( )) {
			    	m = if_correct_pattern.matcher(line); 
				    if (!m.find( )) {
				    	bracket_found = true;
				    	error_occured = line_number;
				    	
				    }
			    }
			
				 m = else_wrong_pattern.matcher(line); 
				    if (m.find( )) {
				    	m = else_correct_pattern.matcher(line); 
					    if (!m.find( )) {
					    	bracket_found = true;
					    	error_occured = line_number;
					    	
					    }
				    }
				    
		}
		}
		
		
		
		br.close();
	}
	

}
