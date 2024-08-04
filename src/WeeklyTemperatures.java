import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {
         // Create an ArrayList to store the names of the days
        ArrayList<String> days = new ArrayList<>();

        // Create an ArrayList to store the temperatures corresponding to each day
        ArrayList<Double> temperatures = new ArrayList<>();
        
        // Create a Scanner object for reading user input        
        Scanner scanner = new Scanner(System.in);

        // Loop to continuously prompt the user for day and temperature input
        while (true) {
            // Prompt the user to enter the day of the week or 'week' to finish
            System.out.print("Enter the day of the week (or 'week' to finish): ");
            String input = scanner.nextLine().trim();

            // Check if the user entered 'week' to break the loop
            if (input.equalsIgnoreCase("week")) {
                break;
            }

            // Validate if input matches any day of the week
            if (!input.matches("(?i)Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday")) {
                System.out.println("Invalid day of the week. Please try again.");
                continue;
            }

            // Check if day has already been entered
            if (days.contains(input)) {
                System.out.println("Day already entered. Please enter a different day.");
                continue;
            }

            // Prompt user to enter the average temperature for the given day
            System.out.print("Enter the average temperature for " + input + ": ");
            double temperature;
            try {
                temperature = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // Handle invalid temperature input
                System.out.println("Invalid temperature. Please try again.");
                continue;
            }

            // Add the valid day and temperature to their matching lists
            days.add(input);
            temperatures.add(temperature);
        }

        // Display all entered days and their respective temperatures
        System.out.println("\nDaily Average Temperatures:");
        double totalTemperature = 0;
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
            totalTemperature += temperatures.get(i);
        }

        // Calculate and display the weekly average temperature
        double weeklyAverage = totalTemperature / days.size();
        System.out.println("\nWeekly Average Temperature: " + String.format("%.2f", weeklyAverage) + "°C");

        // Close the scanner object 
        scanner.close();
    }
}
