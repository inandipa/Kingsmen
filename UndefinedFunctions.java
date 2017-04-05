 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UndefinedFunctions {
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(file);
		Pattern class_pattern = Pattern.compile("(\\s*)class(.*)\\{");
		Pattern function_pattern = Pattern.compile("^(\\s*)(let|var|const)\\s(.+?)(=)(function|\\s*)(.*)(\\s*|\\=\\>)\\{");
		Pattern function_in_class_pattern = Pattern.compile("(.*?)\\((.*)\\)\\{");
		Pattern bracket_end_pattern = Pattern.compile("^(\\s*)\\}(\\s*)$");
		Pattern bracket_start_pattern = Pattern.compile("^(.*)\\{$");
		Pattern object_pattern = Pattern.compile("^(\\s*?)(let|var|const)\\s(.+)(\\s*=\\s*)new\\s*(.+)\\((.*?)\\)\\;$");
		Pattern function_call_pattern = Pattern.compile("(.+)\\((.*)\\)\\;$");
		HashMap< String,String > class_objects= new HashMap< String, String>();
		HashMap< String, ArrayList<String>> class_functions= new HashMap< String, ArrayList<String>>();
		ArrayList<String> global_functions = new ArrayList<String>();
		String line = "";
		String class_name = null;
		Matcher m;
		int line_number = 0;
		int bracket_count = 0;
		while((line = br.readLine()) != null){
			line_number++;
			line = FIleCheckForUnrequiredPatterns.LineCheck(line);
			
			 m = function_pattern.matcher(line); 
			 if (m.find( )) {
				 global_functions.add(m.group(3).trim());
				 //System.out.println(error_occured);
			 }
			 
			 if (bracket_end_pattern.matcher(line).find( )) {
				 //System.out.println(line);
				bracket_count--;
			 } 
			 if (bracket_start_pattern.matcher(line).find( )) {
				//System.out.println(line);
				bracket_count++;
			 } 
			 
			 if(bracket_count == 0 ){
				 class_name = null;
			 }
			 
			 m = class_pattern.matcher(line); 
			 if (m.find( )) {
				 class_name = (m.group(2).trim());
				
			 }
			 
			 m = object_pattern.matcher(line); 
			 if (m.find( )) {
				 class_objects.put(m.group(3).trim(),m.group(5).trim());
			 }
			 
			 m = function_call_pattern.matcher(line); 
			 if (m.find( )) {
				 String call = m.group(1).trim();
				 if(call.split("\\s+").length ==1){
					 if(call.split("\\.").length ==2){
						 String temp_class_name = class_objects.get(call.split("\\.")[0]);
						 if(! class_functions.get(temp_class_name).contains(call.split("\\.")[1])){
							 System.out.println("function called :"+ (String) call + "\nOccured on line : " + line_number);
								
						 }
					 }else{
						 if(! global_functions.contains(call)){
							 System.out.println("function called :"+ (String) call + "\nOccured on line : " + line_number);
						 }
					 }
				 }
			 }
			 
			 if(class_name != null){
				 m = function_in_class_pattern.matcher(line); 
				 if (m.find( )) {
					 String function_line = (m.group(1).trim());
					 String[] parts = function_line.split("\\s+");
					 String function_name = parts[parts.length-1];
					 //System.out.println(function_name);
					 if(class_functions.get(class_name) == null){
						 ArrayList<String> temp = new ArrayList<String>();
						 temp.add(function_name);
						 class_functions.put(class_name, temp);
					 }else{
						class_functions.get(class_name).add(function_name);
					 }
					
				 }
			 }
			 
			
			
		}
		br.close();
		System.out.println("global_functions:"+global_functions);
		System.out.println("class_functions"+class_functions);
		System.out.println("class_objects"+class_objects);
		System.out.println("bracket_count"+bracket_count);
	}


}