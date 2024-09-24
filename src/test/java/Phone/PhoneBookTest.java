package Phone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PhoneBookTest {
    @Test
    public void testAdd() {
        PhoneBook contactBook = new PhoneBook();

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
        PhoneBook contactBook = new PhoneBook();

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
        PhoneBook contactBook = new PhoneBook();

        // Добавляем контакт
        int count = contactBook.add("Alice", "123456789");

        // Получаем номер контакта по имени
        String number = contactBook.findByName("Alice");

        // Проверяем совпадает ли имя
        assertEquals("123456789", contactBook.findByName("Alice"));
        assertEquals("123456789", number);
    }
}
