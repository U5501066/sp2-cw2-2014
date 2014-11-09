package myCW2;

import java.util.Scanner;
//import org.junit.Test;

/**
 * @author Adriano
 *
 */
public class FractionCalculatorTest extends FractionTest{
    // the fraction calculator
    static FractionCalculator calc = new FractionCalculator();
    
    public void testEvaluate(){
        FractionCalculator calc = new FractionCalculator();
        calc.evaluate(new Fraction(0, 1), "");
    }
    
    public static void main(String[] args){
        // scanner to read input from keyboard
        Scanner console = new Scanner(System.in);
        System.out.println("\n**** Simple Fraction Calculator Testing ****");
        System.out.println("type Q/q to exit the program.\n");
        while(true){
            // read input expression from user
            System.out.print("Enter input expression: ");
            String inputString = console.nextLine();
            // break the loop if user types  Q/q
            if(inputString.equalsIgnoreCase("q")){
                break;
            }
            // evaluate the input string using fraction calculator
            Fraction result = calc.evaluate(new Fraction(0,1), inputString);
            
            // display result
            System.out.println(result.toString());
        }
        // close the scanner 
        console.close();
    }
}
