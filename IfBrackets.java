

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfBrackets {

	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern if_wrong_pattern = Pattern.compile("if\\((.*)\\)");
		Pattern if_correct_pattern = Pattern.compile("if\\((.*)\\)(\\s*)\\{");
		Pattern else_correct_pattern = Pattern.compile("else(.*)\\{");
		Pattern else_wrong_pattern = Pattern.compile("else");
		String line = "";
		Matcher m;
		int line_number = 0;
		while((line = br.readLine()) != null){
			line_number++;
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			m = if_wrong_pattern.matcher(line); 
			if (m.find( )) {
				m = if_correct_pattern.matcher(line); 
			    if (!m.find( )) {
			    	 System.out.println("if at line : "+line_number);		    	
				}
			}
			
			m = else_wrong_pattern.matcher(line); 
			if (m.find( )) {
			   	m = else_correct_pattern.matcher(line); 
			    if (!m.find( )) {
			    	 System.out.println("else at line : "+line_number);		    	
			    }
			}
		}
		
		br.close();
	}
	

}
