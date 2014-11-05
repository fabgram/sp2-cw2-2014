/**
 * 
 */
package myPackage;

/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction
{
	private int numerator;
	private int denominator;
	
	//This constructor uses the GCD method to make sure fractions are created in their
	//most simplified form, e.g.: user enters 4/6 but the actual fraction created is 2/3. 
	public Fraction(int num, int denom)
	{
		if (denom == 0)
		{
			System.out.println("Invalid fraction with denominator 0");
			// this should use exceptions
			return;
		}
	
	int gcd = myGcd(num, denom);
	setNumerator(num / gcd);
	setDenominator(denom / gcd);
	}
	
	@Override
	public String toString()
	{
		if(this.getDenominator() == 1) // IF block added to meet assignment criteria on modifying toString()
		{
			return "" + getNumerator();
		}
		
		return "" + getNumerator() + '/' + getDenominator();
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public void setNumerator(int num)
	{
		numerator = num;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	public void setDenominator(int num)
	{
		denominator = num;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Fraction fraction = (Fraction) o;
		if (getDenominator() != fraction.getDenominator()) return false;
		if (getNumerator() != fraction.getNumerator()) return false;
		return true;
	}
	
	@Override
	public int hashCode()
	{
		int result = numerator;
		result = 31 * result + denominator;
		return result;
	}
	
	//This method created by Renan Salviato and Fabricio Graminhani
	public Fraction add(Fraction other)
	{
		int denom = myLcd(this.getDenominator(),other.getDenominator());
		int num = (denom / this.getDenominator() * this.getNumerator()) + (denom / other.getDenominator() * other.getNumerator());
		return new Fraction(num, denom);
	}
	
	//This method created by Renan Salviato and Fabricio Graminhani
	public Fraction subtract(Fraction other)
	{
		int denom = myLcd(this.getDenominator(),other.getDenominator());
		int num = (denom / this.getDenominator() * this.getNumerator()) - (denom / other.getDenominator() * other.getNumerator());
		return new Fraction(num, denom);
	}
	
	public Fraction multiply(Fraction other)
	{
		int num = this.getNumerator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}
	
	//This method created by Renan Salviato and Fabricio Graminhani
	public Fraction divide(Fraction other)
	{
		int num = this.getNumerator() * other.getDenominator();
		int denom = this.getDenominator() * other.getNumerator();
		return new Fraction(num, denom);
	}
	
	private int myGcd(int a, int b)
	{
		while (b != 0)
		{
			int t = b;
			b = a % b;
			a = t;
		}
	return a;
	}
	
	//This method created by Renan Salviato and Fabricio Graminhani and
	//utilises Keith's myGcd()
	private int myLcd(int a, int b)
	{
		 return ((a*b)/myGcd(a,b));
	}
	
	//This method created by Renan Salviato and Fabricio Graminhani
	//If either numerator or denominator in the calling object is negative, it creates
	//a new fraction object with positive values
	public Fraction absValue()
	{
		int a = this.getNumerator();
		int b = this.getDenominator();
		
		if (a < 0)
		{
			a = a * -1; 
		}
				
		if (b < 0)
		{
			b = b * -1;
		}		
		
		return new Fraction (a,b);
	}
	
	//This method created by Renan Salviato and Fabricio Graminhani
	//It simply multiplies the fraction by -1 to change its sign as per assignment criteria
	public Fraction negate()
	{
		int a = this.getNumerator() * -1;
		int b = this.getDenominator();
				
		return new Fraction (a,b);
	}
	
}