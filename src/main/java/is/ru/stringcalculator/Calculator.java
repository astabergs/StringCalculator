package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

		text = checkForNewLineChar(text);

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
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