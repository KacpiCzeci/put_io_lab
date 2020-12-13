package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    @Test
    public void testcalculate() {
        AudiobookPriceCalculator pricecheck = new AudiobookPriceCalculator();
        Audiobook audiobook = new Audiobook("Y", 10.0);
        Customer customer = new Customer("X", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(pricecheck.calculate(customer, audiobook), 0.0, 0.001);
        customer = new Customer("X", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(pricecheck.calculate(customer, audiobook), audiobook.getStartingPrice(), 0.001);
        customer = new Customer("X", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(pricecheck.calculate(customer, audiobook), 0.9*audiobook.getStartingPrice(), 0.001);
        customer = new Customer("X", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(pricecheck.calculate(customer, audiobook), 0.8*audiobook.getStartingPrice(), 0.001);
    }

}