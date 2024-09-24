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

    }
}