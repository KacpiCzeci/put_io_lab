package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testadd() {
        //add + and +
        assertTrue(this.calculator.add(5,5) > 0);
        //add - and -
        assertTrue(this.calculator.add(-5,-5) < 0);
        //add - and + where + == -
        assertTrue(this.calculator.add(-5,5) == 0);
        //add - and + where + > -
        assertTrue(this.calculator.add(-5,10) > 0);
        //add - and + where + < -
        assertTrue(this.calculator.add(-10,5) < 0);
    }

    @Test
    public void testmultiply() {
        //multiply + and +
        assertTrue(this.calculator.multiply(5,5) > 0);
        //multiply - and -
        assertTrue(this.calculator.multiply(-5,-5) > 0);
        //multiply - and +
        assertTrue(this.calculator.multiply(-5,5) < 0);
        //multiply - and 0
        assertTrue(this.calculator.multiply(-5,0) == 0);
        //multiply + and 0
        assertTrue(this.calculator.multiply(5,0) == 0);
    }

    @Test
    public void testaddPositiveNumbers(){ ;
        assertThrows(IllegalArgumentException.class, ()-> {
            this.calculator.addPositiveNumbers(-5, 5);
        });
    }

}