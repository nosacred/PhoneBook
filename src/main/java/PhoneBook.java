import java.util.*;

public class PhoneBook {
    TreeMap<String, String> phonebook = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (name.matches("^\\D+") && phone.matches("^\\d{11}")) {
            phonebook.put(phone, name);
            System.out.println("Контакт сохранен!");
        }
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getNameByPhone(String phone) {
        if (phonebook.containsKey(phone)) {
            return phonebook.get(phone) + " - " + phone;
        } else return "";
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
    }

    public Set<String> getPhonesByName(String name) {
        Set<String> findNames = new TreeSet<>();
        Set<String> contacts = phonebook.keySet();
        for (String s : contacts) {
            if (phonebook.get(s).equals(name)) {
                findNames.add(name + " - " + s);
            }
        }
        if (findNames.isEmpty()) return new TreeSet<>();
        return findNames;
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
    }

    public Set<String> getAllContacts() {
        Set<String> contacts = phonebook.keySet();
        Set<String> allContacts = new TreeSet<>();
        for (String s : contacts) {
            allContacts.add(phonebook.get(s) + " - " + s);
        }
        if (allContacts.isEmpty()) return new TreeSet<>();
        else return allContacts;
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
    }

}