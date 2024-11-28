import org.junit.Test;

import static org.junit.Assert.*;

public class NextDayCalculatorTest {

    @Test
    public void testLeapYearFebruary() {
        // Leap year test for February 29th, 2024
        String result = NextDayCalculator.getNextDay(29, 2, 2024);
        assertEquals("01-03-2024", result); // Next day should be 1st March 2024

        // Non-leap year test for February 28th, 2023
        result = NextDayCalculator.getNextDay(28, 2, 2023);
        assertEquals("01-03-2023", result); // Next day should be 1st March 2023
    }

    @Test
    public void testMonthEndTransition() {
        // Transition from the end of a month to the first of the next month
        String result = NextDayCalculator.getNextDay(31, 1, 2024);
        assertEquals("01-02-2024", result); // Next day should be 1st February 2024

        result = NextDayCalculator.getNextDay(30, 4, 2024);
        assertEquals("01-05-2024", result); // Next day should be 1st May 2024
    }

    @Test
    public void testYearEndTransition() {
        // Transition from December 31st to January 1st of the next year
        String result = NextDayCalculator.getNextDay(31, 12, 2024);
        assertEquals("01-01-2025", result); // Next day should be 1st January 2025
    }

    @Test
    public void testRegularDay() {
        // Regular day, should just increment the day
        String result = NextDayCalculator.getNextDay(15, 3, 2024);
        assertEquals("16-03-2024", result); // Next day should be 16th March 2024
    }

    @Test
    public void testInvalidMonth() {
        // Invalid month (should handle this case gracefully)
        String result = NextDayCalculator.getNextDay(1, 13, 2024); // Month 13 does not exist
        assertNull(result); // Assuming that the implementation should return null or handle invalid month case.
    }

    @Test
    public void testInvalidDay() {
        // Invalid day (should handle this case gracefully)
        String result = NextDayCalculator.getNextDay(32, 12, 2024); // Day 32 does not exist in December
        assertNull(result); // Assuming that the implementation should return null or handle invalid day case.
    }
}
