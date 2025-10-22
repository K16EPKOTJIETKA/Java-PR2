package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TransactionCSVReaderTest {

    @Test
    void testReadTransactions() throws Exception {
        // Створюю тимчасовий CSV-файл з тестовими даними
        Path tempFile = Files.createTempFile("transactions", ".csv");
        Files.write(tempFile, Arrays.asList(
                "2023-01-01,100.5,Депозит",
                "2023-01-02,-50.0,Виведення коштів"
        ));

        // Отримую URL для цього файлу
        URL fileUrl = tempFile.toUri().toURL();

        List<Transaction> result = TransactionCSVReader.readTransactions(fileUrl.toString());

        Assertions.assertEquals(2, result.size(), "Повинно бути 2 транзакції");

        Transaction t1 = result.get(0);
        Transaction t2 = result.get(1);

        Assertions.assertEquals("2023-01-01", t1.getDate());
        Assertions.assertEquals(100.5, t1.getAmount());
        Assertions.assertEquals("Депозит", t1.getDescription());

        Assertions.assertEquals("2023-01-02", t2.getDate());
        Assertions.assertEquals(-50.0, t2.getAmount());
        Assertions.assertEquals("Виведення коштів", t2.getDescription());
    }
}
