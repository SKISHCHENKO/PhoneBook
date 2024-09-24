package Phone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class PhoneBookTest {
    private PhoneBook contactBook;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        contactBook = new PhoneBook();
        // Перенаправляем вывод в ByteArrayOutputStream для тестирования
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testAdd() {
        // Проверяем, что при добавлении нового имени увеличивается количество контактов
        int count = contactBook.add("Alice", "123456789");
        assertEquals(1, count);

        // Добавляем еще одно имя
        count = contactBook.add("Bob", "987654321");
        assertEquals(2, count);

        // Пытаемся добавить имя, которое уже существует
        count = contactBook.add("Alice", "111111111");
        assertEquals(2, count); // Количество контактов не должно увеличиваться

        // Проверяем содержимое контактов
        assertEquals("123456789", contactBook.getContacts().get("Alice"));
        assertEquals("987654321", contactBook.getContacts().get("Bob"));
    }

    @Test
    public void findByNumbers() {
        // Добавляем контакт
        int count = contactBook.add("Alice", "123456789");

        // Получаем имя контакта по телефонному номеру
        String name = contactBook.findByNumber("123456789");

        // Проверяем совпадает ли имя
        assertEquals("Alice", contactBook.findByNumber("123456789"));
        assertEquals("Alice", name);
    }

    @Test
    public void findByName() {
        // Добавляем контакт
        int count = contactBook.add("Alice", "123456789");

        // Получаем номер контакта по имени
        String number = contactBook.findByName("Alice");

        // Проверяем совпадает ли имя
        assertEquals("123456789", contactBook.findByName("Alice"));
        assertEquals("123456789", number);
    }

    @Test
    public void testPrintAllNames() {
        // Добавляем контакты
        contactBook.add("Charlie", "123456789");
        contactBook.add("Alice", "987654321");
        contactBook.add("Bob", "555555555");

        // Очищаем поток перед вызовом метода
        outContent.reset();

        // Вызываем метод printAllNames
        contactBook.printAllNames();

        // Проверяем вывод
        String expectedOutput = "Имена в телефонной книге:\r\n" +
                "Alice\r\n" +
                "Bob\r\n" +
                "Charlie\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
