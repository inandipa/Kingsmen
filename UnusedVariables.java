
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnusedVariables {
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern varible_pattern = Pattern.compile("^(\\s*)(let|var|const)\\s(.+)(=)(.*)");
		String line = "";
		Matcher m;
		ArrayList<String> varibles = new ArrayList<String>();
		int line_number = 0;
		while((line = br.readLine()) != null){
			line_number++;
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			for(int i=0; i<varibles.size();i++){
				Pattern sepcialChar = Pattern.compile("(.*)=(.*)[^A-Za-z0-9]"+varibles.get(i).split(",")[0]+"[^A-Za-z0-9](.*)");
				Pattern object_use = Pattern.compile("(\\s*)"+varibles.get(i).split(",")[0]+"(\\.)(.*)");
				if (sepcialChar.matcher(line).find( ) || object_use.matcher(line).find()) {
					varibles.remove(i);
				}
			}
			  m = varible_pattern.matcher(line);
		    if (m.find( ) ) {
		         varibles.add( m.group(3).trim() + ","+line_number);
		    }
		    
		}
		//System.out.println(varibles);
		
		for(int i=0 ; i< varibles.size(); i++){
			System.out.println(varibles.get(i).split(",")[0]+" occured at "+varibles.get(i).split(",")[1]);
		}
		
		br.close();
	}

}
