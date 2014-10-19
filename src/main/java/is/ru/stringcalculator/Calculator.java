package is.ru.stringcalculator;

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
			return toInt(text); 
		
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
		//delim of any length.
		if(text.contains("[") && text.contains("]")) {
			int start = text.indexOf('[');
			int stop = text.indexOf(']');
			
			del = text.substring(start + 1, stop);
		}
		else {
			del = Character.toString(text.charAt(2));
		}
		int textStart = text.indexOf('\n') + 1;
		text = text.substring(textStart);
		text = text.replace( del , ",");
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

