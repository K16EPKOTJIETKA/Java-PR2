package org.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer
{
    private DateTimeFormatter dateFormatter;

    // Метод для розрахунку загального балансу
    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Вибірка лише витрат (від'ємні значення)
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортування за сумою
                .limit(10) // Обмеження результату першими 10 записами
                .collect(Collectors.toList()); // Збір результату в список
    }

    public static List<Transaction> findMaxMinExpenseInPeriod(List<Transaction> transactions, String startDateStr, String endDateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate startDate = LocalDate.parse(startDateStr, dateFormatter);
        LocalDate endDate = LocalDate.parse(endDateStr, dateFormatter);

        // Фільтрую транзакції, що є витратами та входять у вказаний період
        List<Transaction> expensesInPeriod = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), dateFormatter);
                    return !date.isBefore(startDate) && !date.isAfter(endDate); // входить у період
                })
                .toList();

        if (expensesInPeriod.isEmpty()) {
            return Collections.emptyList();
        }

        Transaction minExpense = Collections.min(expensesInPeriod, Comparator.comparing(Transaction::getAmount));
        Transaction maxExpense = Collections.max(expensesInPeriod, Comparator.comparing(Transaction::getAmount));

        return Arrays.asList(minExpense, maxExpense);
    }
}



