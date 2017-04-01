
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnusedVaribles {
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern pattern = Pattern.compile("^(.*)\\s(.+)(=)(.*)");
		String line = "";
		Matcher m;
		ArrayList<String> varibles = new ArrayList<String>();
		while((line = br.readLine()) != null){
			System.out.println(line);
			for(int i=0; i<varibles.size();i++){
				Pattern sepcialChar = Pattern.compile("(.*)[^A-Za-z0-9]"+varibles.get(i)+"[^A-Za-z0-9](.*)");
				m = sepcialChar.matcher(line);
				if (m.find( )) {
					varibles.remove(i);
				}
			}
			 m = pattern.matcher(line); 
		    if (m.find( )) {
		         System.out.println("Found value: " + m.group(2) );
		         varibles.add( m.group(2).trim());
		    }
		    
		}
		System.out.println(varibles);
		
		br.close();
	}

}
