package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
				
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("//")) {
			String del = Character.toString(text.charAt(2));
			text = text.substring(4);
			text = text.replace( del , ",");
			text = text.replace("\n" , ",");
			String[] num = splitUp(text);
			return sum(num);
		}
		else if(text.contains(",")) {
			text = text.replace("\n", ",");
			String[] num = splitUp(text);	
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
}

