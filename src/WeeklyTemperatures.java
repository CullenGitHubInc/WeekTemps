import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the day of the week (or 'week' to finish): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("week")) {
                break;
            }

            if (!input.matches("(?i)Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday")) {
                System.out.println("Invalid day of the week. Please try again.");
                continue;
            }

            if (days.contains(input)) {
                System.out.println("Day already entered. Please enter a different day.");
                continue;
            }

            System.out.print("Enter the average temperature for " + input + ": ");
            double temperature;
            try {
                temperature = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature. Please try again.");
                continue;
            }

            days.add(input);
            temperatures.add(temperature);
        }

        System.out.println("\nDaily Average Temperatures:");
        double totalTemperature = 0;
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
            totalTemperature += temperatures.get(i);
        }

        double weeklyAverage = totalTemperature / days.size();
        System.out.println("\nWeekly Average Temperature: " + String.format("%.2f", weeklyAverage) + "°C");

        scanner.close();
    }
}
