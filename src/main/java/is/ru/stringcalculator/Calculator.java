package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

		if(text.equals("")){
			return 0;
		}
		text = checkForNewLineChar(text);
		text = changeDelimeters(text);
		text = checkForLargeNumbers(text);
		if (text.contains("-")) {
			checkForNegativeNumbers(text);
		}
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
	private static String changeDelimeters(String text) {
		if(text.startsWith("//")) {
			String delimeter = text.substring(2,3);
			text = text.substring(4);
			text = text.replace(delimeter, ",");
		}
		return text;
		
	}

	private static String checkForLargeNumbers(String text){
		String[] numbers = splitNumbers(text);
		String sum = "";
		for (String n : numbers) {
			if (toInt(n)<=1000)
				sum = sum + n + ",";
		}
		return sum;
	}
    private static void checkForNegativeNumbers(String text){
    	String[] nums = splitNumbers(text);
    	String negs = "";
    	int sum = 0;


    	for (String n : nums) {
    		if (n.contains("-")) {
    			negs = negs + n +", ";
    		}
    	}
    	negs = negs.substring(0, negs.length()-2);

    	if (text.contains("-")) {
    		throw new IllegalArgumentException("Negatives not allowed: " + negs);
    	}
    }
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}