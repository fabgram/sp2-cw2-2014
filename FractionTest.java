package myPackage;

import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Created by Fabricio Graminhani together with Renan Salviato
*/
 
public class FractionTest{	
	
	@Test
	public void testAdd(){
	
		Fraction a = new Fraction(1,2);
		Fraction b = new Fraction(1,3);
		Fraction res = new Fraction(5,6);		
					
		assertTrue(a.add(b).equals(res));		
	}
	
	@Test
	public void testSubtract(){
	
		Fraction a = new Fraction(1,2);
		Fraction b = new Fraction(1,-4);
		Fraction res = new Fraction(3,4);		
					
		assertTrue(a.subtract(b).equals(res));		
	}
	
	@Test
	public void testMultiply(){
	
		Fraction a = new Fraction(-3,1);
		Fraction b = new Fraction(6,1);
		Fraction res = new Fraction(-18,1);		
					
		assertTrue(a.multiply(b).equals(res));		
	}
	
	@Test
	public void testDivide(){
	
		Fraction a = new Fraction(8,4);
		Fraction b = new Fraction(1,2);
		Fraction res = new Fraction(4,1);		
					
		assertTrue(a.divide(b).equals(res));		
	}
	
	@Test
	public void testAbsValue(){
	
		Fraction a = new Fraction(8,2);
		Fraction res = new Fraction(4,1);
		
		Fraction b = new Fraction(-8,2);
		Fraction res1 = new Fraction(4,1);
		
		Fraction c = new Fraction(1,-2);
		Fraction res2 = new Fraction(3,6);
		
		Fraction d = new Fraction(-8,-2);
		Fraction res3 = new Fraction(4,1);
		
		Fraction e = new Fraction(1,-2);
		Fraction res4 = new Fraction(4,1); // test should fail
					
		assertTrue(a.absValue().equals(res));		
		assertTrue(b.absValue().equals(res1));
		assertTrue(c.absValue().equals(res2));
		assertTrue(d.absValue().equals(res3));
		assertTrue(e.absValue().equals(res4)); //should fail
		
	}
	
	@Test
	public void testNegate(){
	
		Fraction a = new Fraction(8,2);
		Fraction res = new Fraction(-8,2);
		
		Fraction b = new Fraction(-8,2);
		Fraction res1 = new Fraction(8,2);
		
		Fraction c = new Fraction(8,-2);
		Fraction res2 = new Fraction(8,2);
		
		Fraction d = new Fraction(-8,-2);
		Fraction res3 = new Fraction(-8,2);
		
		Fraction e = new Fraction(8,-2);
		Fraction res4 = new Fraction(-4,1); // test should fail	
					
		assertTrue(a.negate().equals(res));		
		assertTrue(b.negate().equals(res1));
		assertTrue(c.negate().equals(res2));
		assertTrue(d.negate().equals(res3));
		assertTrue(e.negate().equals(res4)); //should fail
		
	}
	
	@Test
	public void testToString(){
	
		Fraction a = new Fraction(8,1);
		String res = "8";
		
		Fraction b = new Fraction(8,-1);
		String res1 = "-8";
		
		Fraction c = new Fraction(7,3);
		String res2 = "7"; //should fail
				
		assertTrue(a.toString().equals(res));
		assertTrue(b.toString().equals(res1));
		assertTrue(c.toString().equals(res2)); //should fail		
	}
	
}