public class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isHighExpense(double threshold) {
        return this.amount >= threshold;
    }

    public void displayExpense() {
        System.out.println("Category: " + category + " | Amount: $" + amount);
    }
}