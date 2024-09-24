package Phone;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private Map<String, String> contacts = new TreeMap<>();

    public Map<String, String> getContacts() {
        return contacts;
    }

    public int add(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, phoneNumber);
        }
        return contacts.size();
    }

    public String findByNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return "Такого человека нет, поскольку номер отсутствует в телефонной книге!";
    }

    public String findByName(String name){
        if (contacts.containsKey(name)) {
            return contacts.get(name);
        } else {
            return "Такого контакта не существует!";
        }
    }
    public void printAllNames() {
        System.out.println("");
    }
}
