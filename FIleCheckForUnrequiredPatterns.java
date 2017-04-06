import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIleCheckForUnrequiredPatterns {
	static Pattern string_pattern = Pattern.compile("(\"(.*)\")|(\'(.*)\')");
	static Matcher m;

	public static String LineCheck(String line){
		if(line.indexOf("//") != -1){
			line = line.substring(0, line.indexOf("//"));
		}
		m = string_pattern.matcher(line);
		if (m.find( )) {
			line = m.replaceAll("@#@");
		}
		
		return line;
		
	}
}
