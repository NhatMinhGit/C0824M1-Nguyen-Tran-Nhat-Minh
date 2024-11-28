public class NextDayCalculator {

    // Check if a year is a leap year
    public static boolean checkLeapYear(int year) {
        return (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
    }

    // Get the last day of the month
    public static int getLastDayOfMonth(int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12: // Months with 31 days
                return 31;
            case 4, 6, 9, 11: // Months with 30 days
                return 30;
            case 2: // February, check if leap year
                return checkLeapYear(year) ? 29 : 28;
            default:
                return -1; // Invalid month
        }
    }

    // Get the next day as a formatted string
    public static String getNextDay(int day, int month, int year) {
        // Get the last day of the current month
        int lastDay = getLastDayOfMonth(month, year);

        if (day == lastDay) { // If it's the last day of the month
            day = 1; // Reset day to 1
            if (month == 12) { // If it's December, move to next year
                month = 1;
                year++;
            } else {
                month++; // Move to the next month
            }
        } else {
            day++; // Otherwise, just increment the day
        }

        // Return the next day in DD-MM-YYYY format
        return String.format("%02d-%02d-%d", day, month, year);
    }

    public static void main(String[] args) {
        int day = 28, month = 2, year = 2024; // Test case: leap year
        String nextDay = getNextDay(day, month, year);
        System.out.println("Next day: " + nextDay); // Expected: 29-02-2024

        day = 31; month = 12; year = 2024; // Test case: last day of year
        nextDay = getNextDay(day, month, year);
        System.out.println("Next day: " + nextDay); // Expected: 01-01-2025
    }
}
