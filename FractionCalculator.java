package myPackage;

import java.io.EOFException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Fabricio Graminhani 
*/

public class FractionCalculator{
	
	 private static int num = 0; 
	 private static int denom = 0;
	 private static String userInput = "";
	 private static String remValue = "";
	 private static Fraction result = new Fraction(0, 1);
	 private static Fraction inputFraction = new Fraction(0, 1);
	 

	 public static void main (String []args){

		 Scanner keyboard = new Scanner(System.in);	
		 System.out.println("Welcome to Fabricio Graminhani's Fraction Calculator");
		 System.out.print("Please enter the expression to be evaluated: ");
		 while (keyboard.hasNext()) {

			 String input = keyboard.nextLine();

			 try{

				 evaluate(result, input);

			 }catch (EOFException e){

				 System.out.println("Goodbye!");
				 keyboard.close();
				 System.exit(0);

			 }catch (IllegalAccessException e){

				 System.out.println("Error");
				 result.setNumerator(0);
				 result.setDenominator(1);

			 } 

			 System.out.println(result);
		 }

		 keyboard.close();
	 }
	
	
	 public static void evaluate(Fraction frac, String inputString) throws EOFException, IllegalAccessException {

		 //takes each token divided by demiliter " "(spaces)
		 StringTokenizer st = new StringTokenizer(inputString, " ");

		 while (st.hasMoreTokens()){

			 userInput = st.nextToken();

			 if (userInput.contains("/") || userInput.matches("\\d")){

				 checkIsFraction(userInput);

				 if (frac.getNumerator() == 0){

					 frac = frac.add(inputFraction);
				 }
			 }
			 if (userInput.equals("+")){

				 remValue = "+";

			 }else if (userInput.equals("-")){

				 remValue = "-";

			 }else if (userInput.equals("*")){

				 remValue = "*";

			 }else if (userInput.equals("/")){

				 remValue = "/";
			 }

			 if (userInput.matches("a") || userInput.matches("A") || userInput.matches("abs")){

				 frac = frac.absValue();

			 }else if (userInput.matches("n") || userInput.matches("N") ||userInput.matches("neg")) {

				 frac = frac.negate();

			 }else if (userInput.matches("c") || userInput.matches("C") ||userInput.matches("clear")) {

				 frac.setNumerator(0);
				 frac.setDenominator(1);

			 }else if (userInput.matches("q") || userInput.matches("Q") ||userInput.matches("quit")) {

				 throw new EOFException();
			 }

			 //If input does not match, an exception is thrown 
			 else{
				 
				 throw new IllegalAccessException();
			 }
		 }
	 }
	 

	
	
	
	 // The "\\d" idea to check if it is a digit I got from Stack Overflow:
	 //http://stackoverflow.com/questions/15111420/how-to-check-if-a-string-contains-only-digits-in-java
	 //method checks if it is a fraction and sets it to object inputFraction
	 public static void checkIsFraction(String s) throws NumberFormatException{
		 if (s.matches("\\d")){

			 num = Integer.parseInt(s);
			 inputFraction.setNumerator(num);
			 inputFraction.setDenominator(1);

		 }else if (s.contains("/")){

			 StringTokenizer st = new StringTokenizer(s, "/");
			 try{

				 num = Integer.parseInt(st.nextToken());
				 denom = Integer.parseInt(st.nextToken());
				 inputFraction.setNumerator(num);
				 inputFraction.setDenominator(denom);

			 }catch (NumberFormatException e){

				 result.setNumerator(0);
				 result.setDenominator(1);
				 System.out.println("Error");
			 }
		 }
	 }
}
		






