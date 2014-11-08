package myPackage;

/**
 * Created by Keith, modified by Fabricio Graminhani together with Renan Salviato
*/


public class Fraction{

	private int numerator;
	private int denominator;
	
	//This constructor uses the GCD method to make sure fractions are created in their
	//most simplified form, for example if user enters 8/6, the actual fraction created is 2/3. 
	public Fraction(int num, int denom){
	
		if (denom == 0){
		
			System.out.println("Invalid fraction with denominator 0");
			// this should use exceptions
			return;
		}
	
	int gcd = myGcd(num, denom);
	setNumerator(num / gcd);
	setDenominator(denom / gcd);
	}
	
	@Override
	public String toString(){
		
		//Improved toString method to return the numerator (as a String) if the
		//numerator is 1
		if(this.getDenominator() == 1){
		
			return "" + getNumerator();
		}
		
		return "" + getNumerator() + '/' + getDenominator();
	}
	
	public int getNumerator(){
	
		return numerator;
	}
	
	public void setNumerator(int num){
	
		numerator = num;
	}
	
	public int getDenominator(){
	
		return denominator;
	}
	
	public void setDenominator(int num){
	
		denominator = num;
	}
	
	@Override
	public boolean equals(Object o){
	
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Fraction fraction = (Fraction) o;
		if (getDenominator() != fraction.getDenominator()) return false;
		if (getNumerator() != fraction.getNumerator()) return false;
		return true;
	}
	
	@Override
	public int hashCode(){
	
		int result = numerator;
		result = 31 * result + denominator;
		return result;
	}
	
	//add method makes use of the myLcd method to perform the addition
	public Fraction add(Fraction other){
	
		int denom = myLcd(this.getDenominator(),other.getDenominator());
		int num = (denom / this.getDenominator() * this.getNumerator()) + (denom / other.getDenominator() * other.getNumerator());
		return new Fraction(num, denom);
	}
	
	//subtract method also makes use of the myLcd method to perform the addition
	public Fraction subtract(Fraction other){
	
		int denom = myLcd(this.getDenominator(),other.getDenominator());
		int num = (denom / this.getDenominator() * this.getNumerator()) - (denom / other.getDenominator() * other.getNumerator());
		return new Fraction(num, denom);
	}
	
	public Fraction multiply(Fraction other){
	
		int num = this.getNumerator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}
	
	//divide method 
	public Fraction divide(Fraction other){
	
		int num = this.getNumerator() * other.getDenominator();
		int denom = this.getDenominator() * other.getNumerator();
		return new Fraction(num, denom);
	}
	
	private int myGcd(int a, int b){
	
		while (b != 0)
		{
			int t = b;
			b = a % b;
			a = t;
		}
	return a;
	}
	
	//method used to get the Lower Common Denominator. To be used in the add 
	//and subtract methods
	private int myLcd(int a, int b){
	
		 return ((a*b)/myGcd(a,b));
	}
	
	//If either numerator or denominator negative, it creates
	//a new fraction object with positive values
	public Fraction absValue(){
	
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
	
	//It simply multiplies the fraction by -1 to change its sign as per assignment criteria
	public Fraction negate(){
	
		int a = this.getNumerator() * -1;
		int b = this.getDenominator();
				
		return new Fraction (a,b);
	}
	
}