package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

		if(text.equals("")){
			return 0;
		}
		text = checkForNewLineChar(text);

		String[] numbers = splitNumbers(text);
		String sum = "";
		for (String n : numbers) {
			if (toInt(n)<=1000)
				sum = sum + n + ",";
		}
		text = sum;
		
		if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}

	private static String checkForNewLineChar(String text) {
		if(text.contains("\n")) {
			text=text.replace("\n",",");
		}
		return text;
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}