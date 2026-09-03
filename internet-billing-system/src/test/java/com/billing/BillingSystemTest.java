package com.billing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BillingSystemTest {

    @Test
    public void testBasicPlanWithinLimit() {
        assertEquals(20.00, BillingSystem.calculateBill("basic", 45.0), 0.001);
    }

    @Test
    public void testBasicPlanExceedingLimit() {
        // 50GB limit base ($20) + 10GB extra * $0.50 = $25.00
        assertEquals(25.00, BillingSystem.calculateBill("Basic", 60.0), 0.001);
    }

    @Test
    public void testStandardPlanExceedingLimit() {
        // 100GB limit base ($40) + 20GB extra * $0.30 = $46.00
        assertEquals(46.00, BillingSystem.calculateBill("standard", 120.0), 0.001);
    }

    @Test
    public void testPremiumPlanUnlimited() {
        assertEquals(70.00, BillingSystem.calculateBill("premium", 999.5), 0.001);
    }

    @Test
    public void testInvalidPlanThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BillingSystem.calculateBill("invalid_plan", 50.0);
        });
    }
}
