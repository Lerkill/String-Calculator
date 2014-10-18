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
			//illegal arg
			for(String n: num) {
				if (toInt(n) < 0) {
					String s = "Negatives not allowed " + n;	
					throw new IllegalArgumentException(s);
				}
				
			}
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
			summa += toInt(num);
		}
		return summa;
	}

	private static String delimiter(String text) {
		String del = Character.toString(text.charAt(2));
		text = text.substring(4);
		text = text.replace( del , ",");
		return text;
	}
}

