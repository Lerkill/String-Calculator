package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
	public void testManyNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewlineNumbers() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testDelimiter() {
		assertEquals(6, Calculator.add("//;\n1;2;3"));
	}
	
	@Test
	public void testNoNegAllowed(){
		try { 
			Calculator.add("-1,2"); 
		}
		catch(IllegalArgumentException ex){
			assertEquals("Negatives not allowed: -1", ex.getMessage());
		}
	}
	@Test
	public void testNoNegAllowed2(){
		try { 
			Calculator.add("2,-4,3,-5"); 
		}
		catch(IllegalArgumentException ex){
			assertEquals("Negatives not allowed: -4 -5", ex.getMessage());
		}
	}

	@Test
	public void testLargerThanThou() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testMultyDelims() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void testMultyDelims2() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void testDelimsOfAnyLength() {
		assertEquals(21, Calculator.add("//[**][%][$$$]\n1**2%3$$$4,5\n6"));
	}
}  
