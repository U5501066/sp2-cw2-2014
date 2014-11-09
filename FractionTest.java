/**
 * Created by keith for the second coursework assignment.
 *
 * You need to recode this as a series of JUnit tests
 */
package myCW2;

import static junit.framework.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FractionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testZeroDenom() {
        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
    }

    @Test
    public void testMultiply() {
        // test multiply
        assertEquals(new Fraction(3, 10), new Fraction(1, 2).multiply(new Fraction(3, 5)));
        assertEquals(new Fraction(1, 3), new Fraction(1, 2).multiply(new Fraction(4, 6)));
    }

    @Test
    public void testAdd() {
        // test multiply
        assertEquals(new Fraction(11, 10), new Fraction(1, 2).add(new Fraction(3, 5)));
        assertEquals(new Fraction(7, 6), new Fraction(1, 2).add(new Fraction(4, 6)));
    }

    @Test
    public void testSubtract() {
        // test multiply
        assertEquals(new Fraction(-1, 10), new Fraction(1, 2).subtract(new Fraction(3, 5)));
        assertEquals(new Fraction(-1, 6), new Fraction(1, 2).subtract(new Fraction(4, 6)));
    }

    @Test
    public void testDivide() {
        // test multiply
        assertEquals(new Fraction(5, 6), new Fraction(1, 2).divide(new Fraction(3, 5)));
        assertEquals(new Fraction(3, 4), new Fraction(1, 2).divide(new Fraction(4, 6)));
    }

    @Test
    public void testEquals() {
        // test equals
        assert (new Fraction(1, 2).equals(new Fraction(1, 2)));
        assert (new Fraction(1, 2).equals(new Fraction(3, 6)));
        assert (new Fraction(-1, 2).equals(new Fraction(1, -2)));
        assert (new Fraction(-1, -2).equals(new Fraction(1, 2)));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FractionTest.class);
        if(result.wasSuccessful()){
            System.out.println("All tests passed.");
        }
        else{
            System.out.println("Following tests failed:");
        }
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        
    }
}
