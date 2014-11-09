package myCW2;

/**
 * @author Adriano
 *
 */
public class FractionCalculator extends Fraction {

    public FractionCalculator(){
        super(0,1);
    }
    
    private boolean isOperator(String s){
        return (s.equals("+") || s.equals("/") || s.equals("-") || s.equals("*"));
    }
    
    Fraction evaluate(Fraction startFraction, String inputString) {
        String[] tokens = inputString.split(" ");
        Fraction currentVal = startFraction;
        String opRemembered = null;
        for(String tok: tokens){
            if(isOperator(tok)){  // operator 
                // check whether we already remembered an operator
                if(opRemembered != null){
                    throw new IllegalArgumentException("illegal input expression");
                }
                else{
                    opRemembered = tok;
                }
            } else if(tok.equalsIgnoreCase("q") || tok.equalsIgnoreCase("quit") ){
                throw new IllegalArgumentException("input encountered q/Q/quit");
            } else if(tok.equalsIgnoreCase("c") || tok.equalsIgnoreCase("clear") ){
                currentVal = new Fraction(0, 1);
            } else if(tok.equalsIgnoreCase("a") || tok.equalsIgnoreCase("abs") ){
                currentVal = currentVal.abs();
            } else if(tok.equalsIgnoreCase("n") || tok.equalsIgnoreCase("neg") ){
                currentVal = currentVal.negate();
            } else{
                // this should be a whole number or a fraction
                Fraction frac = Fraction.parseFraction(tok);
                if(opRemembered != null){
                    switch(opRemembered.charAt(0)){
                        case '+':
                            currentVal = currentVal.add(frac);
                            break;
                        case '-':
                            currentVal = currentVal.subtract(frac);
                            break;
                        case '/':
                            currentVal = currentVal.divide(frac);
                            break;
                        case '*':
                            currentVal = currentVal.multiply(frac);
                            break;
                    }
                    opRemembered = null;
                } else{
                    currentVal = frac;
                }
            }
        }
        return currentVal;
    }

}
