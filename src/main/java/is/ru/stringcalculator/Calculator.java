package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")) {
			String[] numbers = text.split(",");
			int sum = 0;
			for(String n : numbers) {
				sum += toInt(n);
			}
			return sum;
		}
		else
			return toInt(text); 
		
	}
	private static int toInt(String n) {
		return Integer.parseInt(n);
	}
}

