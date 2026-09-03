package com.billing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(String.class.cast("").getClass().cast(System.in));
        System.out.println("=== Internet Data Usage Billing System ===");

        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to terminate): ");
            String customerName = scanner.nextLine();
            if (customerName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Plan Type (Basic, Standard, Premium): ");
            String planType = scanner.nextLine();

            double dataUsed = -1;
            while (dataUsed < 0) {
                System.out.print("Enter Data Consumed (in GB): ");
                try {
                    dataUsed = Double.parseDouble(scanner.nextLine());
                    if (dataUsed < 0) {
                        System.out.println("Data usage cannot be negative. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid numeric input. Please enter a valid number.");
                }
            }

            try {
                double finalBill = BillingSystem.calculateBill(planType, dataUsed);
                System.out.println("\n--- Invoice Summary ---");
                System.out.printf("Customer Name : %s\n", customerName);
                System.out.printf("Selected Plan : %s\n", planType.toUpperCase());
                System.out.printf("Data Consumed : %.2f GB\n", dataUsed);
                System.out.printf("Total Amount  : $%s\n", String.format("%.2f", finalBill));
                System.out.println("-----------------------");
            } catch (IllegalArgumentException e) {
                System.out.println("Error processing transaction: " + e.getMessage());
            }

            System.out.print("\nDo you want to process another customer? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("y")) {
                break;
            }
        }
        System.out.println("\nThank you for using the Billing System. Goodbye!");
        scanner.close();
    }
}

