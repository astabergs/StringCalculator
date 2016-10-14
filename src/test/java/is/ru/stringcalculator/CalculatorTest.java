package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers() {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLineChar() {
    	assertEquals(10, Calculator.add("4\n6"));
    }

    @Test
    public void testremoveNumberOver1000() {
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testDelimeter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testManyNumbers() {
    	assertEquals(3+5+6+7+19+100, Calculator.add("3,5,6,7,19,100"));
    }

    /*@Test
    public void testOneNegative() {
    	Boolean exception = false;
    	try {
    		Calculator.add("-2");
    	}
    	catch (IllegalArgumentException e){
    		exception=true;
    	}
    	assertTrue(exception);
    	assertEquals("Negatives not allowed: -2", e.getMessage());
    }*/

   /* @Test (excpected = IllegalArgumentException.class)
    public final void testIfExceptionThrown() {
    	Calulator.add("-2");
    }*/

    /*@Rule
    	public ExpectedException thrown = ExpectedException.none();

    	@Test 
    	public void throwsExceptionOneNegative() {
    		thrown.expect(IllegalArgumentException.class);
    		thrown.expectMessage(equalTo("Negatives not allowed: -2"));

    		Calculator.add("-2,1");
    	}*/
}