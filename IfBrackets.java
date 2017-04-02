
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
		Pattern if_correct_pattern = Pattern.compile("if\\((.*)\\)(.*)\\{");
		Pattern else_correct_pattern = Pattern.compile("else(.*)\\{");
		Pattern else_wrong_pattern = Pattern.compile("else");
		String line = "";
		Matcher m;
		boolean if_occured = false;
		boolean else_occured = false;
		while((line = br.readLine()) != null){
			//System.out.println(line);
		
				m = if_wrong_pattern.matcher(line); 
			    if (m.find( )) {
			    	m = if_correct_pattern.matcher(line); 
				    if (!m.find( )) {
				    	if_occured = true;
				    	System.out.println(line);
				    }
			    }
			
				m = else_wrong_pattern.matcher(line); 
				if (m.find( )) {
				   	m = else_correct_pattern.matcher(line); 
					if (!m.find( )) {
					    else_occured = true;
					    System.out.println(line);
					}
				}

		}
		
		br.close();
	}

}
