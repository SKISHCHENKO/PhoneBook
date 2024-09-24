package Phone;


public class Main {
    public static void main(String[] args) {
        PhoneBook contactBook = new PhoneBook();
        int countContacts;
        countContacts = contactBook.add("Alice", "123456789");
        System.out.println("Количество контактов: "+ countContacts);
        countContacts = contactBook.add("Bob", "987654321");
        System.out.println("Количество контактов: "+ countContacts);
    }
}