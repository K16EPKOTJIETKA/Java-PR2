package org.example;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        for (Transaction transaction : transactions) {
                System.out.println(transaction);
        }

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);
        //System.out.println("Загальний баланс: " + totalBalance);


        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(monthYear,transactions);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        String firstDate = "01-01-2024";
        String lastDate = "05-01-2024";
        List<Transaction> maxMinExpenses = TransactionAnalyzer.findMaxMinExpenseInPeriod(transactions, firstDate, lastDate);
        TransactionReportGenerator.printMaxMinExpensesReport(maxMinExpenses);

        TransactionReportGenerator.generateExpenseReport(transactions);
        //System.out.println("Кількість транзакцій за " + monthYear + ": " + transactionsCount);


    }
}
