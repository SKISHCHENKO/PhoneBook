package Phone;


public class Main {
    public static void main(String[] args) {
        PhoneBook contactBook = new PhoneBook();
        int countContacts;
        countContacts = contactBook.add("Alice", "123456789");
        System.out.println("Количество контактов: "+ countContacts);
        countContacts = contactBook.add("Bob", "987654321");
        System.out.println("Количество контактов: "+ countContacts);

        String phoneNumber ="111111";
        String name = contactBook.findByNumber(phoneNumber);
        System.out.println("Имя человека, на которого записан номер " + phoneNumber+" : " + name);
        phoneNumber = "987654321";
        name = contactBook.findByNumber(phoneNumber);
        System.out.println("Имя человека, на которого записан номер " + phoneNumber+" : " + name);

        String nameContact = "Alice";
        String numberContact = contactBook.findByName(nameContact);
        System.out.println("Номер " + nameContact +" : " + numberContact);

        contactBook.add("Charlie", "123456789");
        contactBook.add("Alice", "987654321");
        contactBook.add("Bob", "555555555");

        contactBook.printAllNames();
    }
}