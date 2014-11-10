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
	 private static Fraction fracValue = new Fraction(0, 1);
	 private static Fraction inputFraction = new Fraction(0, 1);
	 

	 public static void main (String []args){

		 Scanner keyboard = new Scanner(System.in);	
		 System.out.println("Welcome to Fabricio Graminhani's Fraction Calculator");
		 System.out.print("Please enter the expression to be evaluated: ");
		 while (keyboard.hasNext()) {

			 String input = keyboard.nextLine();

			 try{

				 evaluate(fracValue, input);

			 }catch (EOFException e){

				 System.out.println("Goodbye!");//message if user quits 
				 keyboard.close();
				 System.exit(0);

			 }catch (IllegalAccessException e){

				 resetInput();//method resets all input variables
				 System.out.println("Error, the program will reset.");
				 

			 } 

			 System.out.println(fracValue);
		 }

		 keyboard.close();
	 }
	
	
	 public static void evaluate(Fraction frac, String inputString) throws EOFException, IllegalAccessException {

		 //takes each token divided by delimiter " "(spaces)
		 StringTokenizer st = new StringTokenizer(inputString, " ");

		 while (st.hasMoreTokens()){

			 userInput = st.nextToken();

			 if (userInput.contains("/") || userInput.matches("\\d")){

				 checkIsFraction(userInput);

			 }else if (frac.getNumerator() == 0){

				 frac = frac.add(inputFraction);
				 
			//conditionals for the operators

			 }else if (userInput.equals("+")){

				 remValue = "+";

			 }else if (userInput.equals("-")){

				 remValue = "-";

			 }else if (userInput.equals("*")){

				 remValue = "*";

			 }else if (userInput.equals("/")){

				 remValue = "/";
				 
			//conditionals for the modifiers

			 }if (userInput.matches("a") || userInput.matches("A") || userInput.matches("abs")){

				 frac = frac.absValue();

			 }else if (userInput.matches("n") || userInput.matches("N") || userInput.matches("neg")) {

				 frac = frac.negate();

			 }else if (userInput.matches("c") || userInput.matches("C") || userInput.matches("clear")) {

				 frac.setNumerator(0);
				 frac.setDenominator(1);

			 }else if (userInput.matches("q") || userInput.matches("Q") || userInput.matches("quit")) {

				 throw new EOFException();
			 }

			 //If input does not match, an exception is thrown 
			 else{

				 throw new IllegalAccessException();
			 }


			 //loop to try to do the operations
			 while (st.hasMoreTokens() && !(remValue.equals(""))){

				 if (remValue.equals("+")){

					 userInput = st.nextToken();

				 }else{

					 checkIsFraction(userInput);
					 frac = frac.add(inputFraction);
					 remValue = "";

				 }if (remValue.equals("-")){

					 userInput = st.nextToken();

				 }else{

					 checkIsFraction(userInput);
					 frac = frac.subtract(inputFraction);
					 remValue = "";

				 }if (remValue.equals("*")){

					 userInput = st.nextToken();

				 }else{

					 checkIsFraction(userInput);
					 frac = frac.multiply(inputFraction);
					 remValue = "";

				 }if (remValue.equals("/")){

					 userInput = st.nextToken();

				 }else{

					 checkIsFraction(userInput);
					 frac = frac.divide(inputFraction);
					 remValue = "";
				 }
			 }

		 }

		 // result of evaluation
		 fracValue = frac;
	 }

	
	 //method to reset operations
	 public static void resetInput(){
		 
		 fracValue.setNumerator(0);
		 fracValue.setDenominator(1);
		 inputFraction.setNumerator(0);
		 inputFraction.setDenominator(1);
		 remValue = "";
	 }

	 // The "\\d" idea to check if it is a digit I got from Stack Overflow:
	 //http://stackoverflow.com/questions/15111420/how-to-check-if-a-string-contains-only-digits-in-java
	 //method checks if it is a fraction and sets it to object inputFraction
	 public static void checkIsFraction(String s) throws NumberFormatException{

		 try{
			 if (s.matches("\\d")){

				 num = Integer.parseInt(s);
				 inputFraction.setNumerator(num);
				 inputFraction.setDenominator(1);

			 }else if (s.contains("/")){

				 StringTokenizer st = new StringTokenizer(s, "/");
				 num = Integer.parseInt(st.nextToken());
				 denom = Integer.parseInt(st.nextToken());
				 inputFraction.setNumerator(num);
				 inputFraction.setDenominator(denom);
			 }
		 }catch (NumberFormatException e){

			 resetInput();
			 System.out.println("Error");
		 }
	 }
	 
}
		 
		 
	 

		






