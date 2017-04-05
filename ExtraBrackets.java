
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraBrackets {

	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern indentation_pattern = Pattern.compile("(\\s*)(.*)");
		Pattern bracket_end_pattern = Pattern.compile("(\\s*)\\}");
		Pattern bracket_start_pattern = Pattern.compile("(\\s*)(.+)\\{");
		String line = "";
		String Pre_line = "";
		int Pre_line_indentation_lenght = 0, line_indentation_length=0;
		int line_number = 0;
		Matcher m;
		int bracket_count = 0;
		while((line = br.readLine()) != null){
			line_number++;
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			if(line.equals("") ){
				continue;
			}
			
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
			
			
			m= indentation_pattern.matcher(line);
			if(m.find( )) {
				 String s = m.group(1);
				 line_indentation_length = s.length();
			 }
			if(Pre_line_indentation_lenght < line_indentation_length && line_number != 1){
				m= bracket_start_pattern.matcher(Pre_line);
				if(!m.find( )) {
					System.out.println("open bracket missing at line:"+ --line_number);
					line_number++;
				 }
			}
			
			if(Pre_line_indentation_lenght > line_indentation_length  && line_number != 1){
				m= bracket_end_pattern.matcher(line);
				if(!m.find( )) {
					System.out.println("close bracket missing at line:"+ line_number);
				 }
			}
			
			Pre_line = line;
			Pre_line_indentation_lenght = line_indentation_length;
		}
		br.close();
		if(bracket_count < 0){
			System.out.println("the file has "+ Math.abs(bracket_count)+ " extra close bracket");
			
		}else if(bracket_count > 0){
			System.out.println("the file has "+ Math.abs(bracket_count)+ " extra open bracket");
		}else{
			System.out.println("the file dont have any extra brackets");
		}
		
	}


}

