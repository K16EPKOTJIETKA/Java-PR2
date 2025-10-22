package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TransactionAnalyzerTest {
    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Створення екземпляру TransactionAnalyzer з тестовими даними
        //TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        // Виклик методу, який потрібно протестувати
        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        // Перевірка результату
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        // Підготовка тестових даних
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        int countFeb = TransactionAnalyzer.countTransactionsByMonth("02-2023", transactions);
        int countMar = TransactionAnalyzer.countTransactionsByMonth("03-2023", transactions);

        // Перевірка результатів
        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testFindTopExpensesCountEqual10()
    {
        Transaction transaction1 = new Transaction("01-02-2023", -50.0, "Витрата");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", -100.0, "Витрата");
        Transaction transaction4 = new Transaction("01-02-2023", -500.0, "Витрата");
        Transaction transaction5 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction6 = new Transaction("05-03-2023", -1900.0, "Витрата");
        Transaction transaction7 = new Transaction("01-02-2023", -590.0, "Витрата");
        Transaction transaction8 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction9 = new Transaction("05-03-2023", -100.0, "Витрата");
        Transaction transaction10 = new Transaction("01-02-2023", -1050.0, "Витрата");
        Transaction transaction11 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction12 = new Transaction("05-03-2023", -100.0, "Витрата");
        Transaction transaction13 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction14 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction15 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction16 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction17 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction18 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2,
                transaction3, transaction4, transaction5, transaction6, transaction7, transaction8,
                transaction9, transaction10, transaction11,
                transaction12, transaction13, transaction14, transaction15, transaction16,
                transaction17, transaction18);

        int expensesCount = TransactionAnalyzer.findTopExpenses(transactions).size();

        Assertions.assertEquals(10, expensesCount, "Неправильна кількість");
    }

    @Test
    public void testFindTopExpensesCountEqual8()
    {
        Transaction transaction1 = new Transaction("01-02-2023", -50.0, "Витрата");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", -100.0, "Витрата");
        Transaction transaction4 = new Transaction("01-02-2023", -500.0, "Витрата");
        Transaction transaction5 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction6 = new Transaction("05-03-2023", -1900.0, "Витрата");
        Transaction transaction7 = new Transaction("01-02-2023", -590.0, "Витрата");
        Transaction transaction8 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction9 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction10 = new Transaction("01-02-2023", -1050.0, "Витрата");
        Transaction transaction11 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction12 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction13 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction14 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction15 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction16 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction17 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction18 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2,
                transaction3, transaction4, transaction5, transaction6, transaction7, transaction8,
                transaction9, transaction10, transaction11,
                transaction12, transaction13, transaction14, transaction15, transaction16,
                transaction17, transaction18);

        int expensesCount = TransactionAnalyzer.findTopExpenses(transactions).size();

        Assertions.assertEquals(8, expensesCount, "Неправильна кількість");
    }

    @Test
    public void testFindTopExpenses()
    {
        Transaction transaction1 = new Transaction("01-02-2023", -800.0, "Витрата");
        Transaction transaction2 = new Transaction("15-02-2023", -900.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", -1000.0, "Витрата");
        Transaction transaction4 = new Transaction("01-02-2023", -1100.0, "Витрата");
        Transaction transaction5 = new Transaction("15-02-2023", -1200.0, "Витрата");
        Transaction transaction6 = new Transaction("05-03-2023", -1300.0, "Витрата");
        Transaction transaction7 = new Transaction("01-02-2023", -1400.0, "Витрата");
        Transaction transaction8 = new Transaction("15-02-2023", -1500.0, "Витрата");
        Transaction transaction9 = new Transaction("05-03-2023", -1600.0, "Витрата");
        Transaction transaction10 = new Transaction("01-02-2023", -1700.0, "Витрата");
        Transaction transaction11 = new Transaction("15-02-2023", -1800.0, "Витрата");
        Transaction transaction12 = new Transaction("05-03-2023", -1900.0, "Витрата");
        Transaction transaction13 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction14 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction15 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction16 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction17 = new Transaction("15-02-2023", 20.0, "Дохід");
        Transaction transaction18 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2,
                transaction3, transaction4, transaction5, transaction6, transaction7, transaction8,
                transaction9, transaction10, transaction11,
                transaction12, transaction13, transaction14, transaction15, transaction16,
                transaction17, transaction18);

        List<Transaction> expensesTransactions = TransactionAnalyzer.findTopExpenses(transactions);
        List<Transaction> rightTransactions = Arrays.asList(transaction12, transaction11,
                transaction10, transaction9, transaction8, transaction7, transaction6, transaction5,
                transaction4, transaction3);

        Assertions.assertEquals(rightTransactions, expensesTransactions, "Неправильний порядок");
    }
}
