/**
 * 
 */
package myPackage;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Fabricio Graminhani 
*/


public class FractionCalculatorTest {

	@Test
	public void testreset() {

		assertTrue(FractionCalculator.resetInput("2"));
		assertTrue(FractionCalculator.resetInput("-3"));
	}
	
	@Test
	public void testcheckIsFraction() {

		assertTrue(FractionCalculator.checkIsFraction("2/3"));
		assertTrue(FractionCalculator.checkIsFraction("-3/4"));
	}
	
	
	
}

