import java.util.Scanner;

public class BudgetTracker {

    // Calculates the actual total spending across array items
    public static double calculateTotalSpending(Expense[] expenses, int count) {
        double sumAmount = 0.0;
        for (int i = 0; i < count; i++) {
            if (expenses[i] != null) {
                sumAmount += expenses[i].getAmount();
            }
        }
        return sumAmount;
    }

    // Prints summary comparing budget vs spending
    public static void printBudgetSummary(double budget, double totalSpent) {
        System.out.println("\n--- BUDGET SUMMARY ---");
        System.out.printf("Total Budget: $%.2f\n", budget);
        System.out.printf("Total Spent: $$%.2f\n", totalSpent);
        if (totalSpent > budget) {
            System.out.printf("Status: Over Budget by $%.2f\n", (totalSpent - budget));
        } else {
            System.out.printf("Status: Under Budget! Remaining: $%.2f\n", (budget - totalSpent));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your total budget for the month: $");
        double monthlyBudget = scanner.nextDouble();

        System.out.print("How many expenses would you like to log? ");
        int maxExpenses = scanner.nextInt();

        Expense[] expenseList = new Expense[maxExpenses];

        for (int i = 0; i < maxExpenses; i++) {
            System.out.print("\nEnter category for expense #" + (i + 1) + ": ");
            String cat = scanner.next();
            
            System.out.print("Enter amount: $");
            double amt = scanner.nextDouble();

            expenseList[i] = new Expense(cat, amt);

            if (expenseList[i].isHighExpense(300.0)) {
                System.out.println("Alert: High expense recorded!");
            }
        }

        double total = calculateTotalSpending(expenseList, maxExpenses);
        printBudgetSummary(monthlyBudget, total);

        // Code timing benchmark for Part B.2
        int largeSize = 1000000;
        Expense[] largeArray = new Expense[largeSize];
        for (int i = 0; i < largeSize; i++) {
            largeArray[i] = new Expense("Item", 10.0);
        }

        long startTime = System.nanoTime();
        calculateTotalSpending(largeArray, largeSize);
        long endTime = System.nanoTime();

        System.out.println("\nTiming for " + largeSize + " items: " + (endTime - startTime) + " ns");
    }
}