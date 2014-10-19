package is.ru.stringcalculator;
import java.util.ArrayList;
public class Calculator {

	public static int add(String text){		
		if(text.equals("")){
			return 0;
		}
		else if(text.length() > 1){
			if(text.contains("//")) {
				text = delimiter(text);
			}
			text = text.replace("\n", ",");
			String[] num = splitUp(text);			
			//check if any neq numbers, if so, throw exception
			testValid(num); 			
			return sum(num);
		}
		else
			return toInt(text); //if only 1 number. 		
	}

	private static int toInt(String n) {
		return Integer.parseInt(n);
	}

	private static String[] splitUp(String n) {
		return n.split(",");
	}

	private static int sum(String[] n) {
		int summa = 0;
		for(String num : n) {
			if(toInt(num) > 1000) { //invalid if number is larger than 1000
				continue;
			}
			summa += toInt(num);
		}
		return summa;
	}

	private static String delimiter(String text) {
		String del;
		ArrayList<String> delims = new ArrayList<String>();
		//delim of any length and type
		if(text.contains("[") && text.contains("]")) {
			for(int i = 0; i < text.indexOf('\n') ; i++) {
				if(text.charAt(i) == '['){
					int stop = text.indexOf(']', i);	
					del = text.substring(i+1, stop);
					delims.add(del);
				}			
			}			
		}
		else {
			del = Character.toString(text.charAt(2));
			delims.add(del);
		}
		int textStart = text.indexOf('\n') + 1;
		text = text.substring(textStart);
		//replace delimiter with ','
		for(String d: delims) {
			text = text.replace( d , ",");
		}	
		return text;
	}

	private static void testValid(String[] num) {
		boolean found = false;
		String message = "Negatives not allowed:";
		for(String n: num) {
			if (toInt(n) < 0) { //check neq
				message +=" " + n;	
				found = true;
			}
		}
		if(found)
			throw new IllegalArgumentException(message);	
	}
}

