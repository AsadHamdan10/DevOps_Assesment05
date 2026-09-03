package com.billing;

public class BillingSystem {

    // Plan Configuration Rules
    // Basic: $20 for up to 50 GB. Extra data costs $0.50 per GB.
    // Standard: $40 for up to 100 GB. Extra data costs $0.30 per GB.
    // Premium: $70 for unlimited data (no limits, no overage fees).

    public static double calculateBill(String planType, double dataConsumedGB) {
        if (dataConsumedGB < 0) {
            throw new IllegalArgumentException("Data consumption cannot be negative.");
        }

        String plan = planType.trim().toLowerCase();
        double baseRate;
        double dataLimit;
        double extraChargePerGB;

        switch (plan) {
            case "basic":
                baseRate = 20.00;
                dataLimit = 50.0;
                extraChargePerGB = 0.50;
                break;
            case "standard":
                baseRate = 40.00;
                dataLimit = 100.0;
                extraChargePerGB = 0.30;
                break;
            case "premium":
                baseRate = 70.00;
                dataLimit = Double.MAX_VALUE; // Unlimited data allocation
                extraChargePerGB = 0.00;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type selected: " + planType);
        }

        double totalBill = baseRate;
        if (dataConsumedGB > dataLimit) {
            double extraData = dataConsumedGB - dataLimit;
            totalBill += extraData * extraChargePerGB;
        }

        return totalBill;
    }
}
