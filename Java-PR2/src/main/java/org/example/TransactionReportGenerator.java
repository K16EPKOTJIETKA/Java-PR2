package org.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }

    }

    public static void printMaxMinExpensesReport(List<Transaction> maxMinExpenses) {
        if (maxMinExpenses.isEmpty()) {
            System.out.println("Витрат за вказаний період не було");
            return;
        }
        System.out.println("Максимальна та мінімальна витрати:");
        for (Transaction expense : maxMinExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void generateExpenseReport(List<Transaction> transactions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int scale = 1000;

        List<Transaction> expenses = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .toList();

        if (expenses.isEmpty()) {
            System.out.println("Немає витрат для звіту.");
            return;
        }

        Map<String, Double> expensesByCategory = expenses.stream()
                .collect(Collectors.groupingBy(Transaction::getDescription,
                        Collectors.summingDouble(Transaction::getAmount)));

        System.out.println("===== ВИТРАТИ ПО КАТЕГОРІЯХ =====");
        for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
            double total = Math.abs(entry.getValue());
            int stars = (int) (total / scale);
            System.out.printf("%-15s : %8.2f грн | %s%n", entry.getKey(), total, "*".repeat(stars));
        }

        Map<String, Double> expensesByMonth = expenses.stream()
                .collect(Collectors.groupingBy(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), formatter);
                    return date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
                }, Collectors.summingDouble(Transaction::getAmount)));

        System.out.println("\n===== ВИТРАТИ ПО МІСЯЦЯХ =====");
        for (Map.Entry<String, Double> entry : expensesByMonth.entrySet()) {
            double total = Math.abs(entry.getValue());
            int stars = (int) (total / scale);
            System.out.printf("%-10s : %8.2f грн | %s%n", entry.getKey(), total, "*".repeat(stars));
        }
    }
}
