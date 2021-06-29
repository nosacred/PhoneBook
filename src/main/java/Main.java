import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Введите команду, имя или телефон");
            String s = scanner.nextLine();
            if (s.equals("LIST")) System.out.println(phoneBook.getAllContacts());
            else if (s.matches("\\D+")) {
                phoneBook.getPhonesByName(s);
                System.out.println("Введите номер телефона для контакта " + s);
                String s2 = scanner.nextLine();
                if (s2.matches("\\d{11}")) phoneBook.addContact(s2, s);
            } else if (s.matches("\\d{11}")) {
                phoneBook.getNameByPhone(s);
                System.out.println("Введите имя для абонента " + s);
                String s2 = scanner.nextLine();
                if (s2.matches("\\D+")) {
                    phoneBook.addContact(s, s2);
                }
            } else if (s.equals("0")) break;

        }
    }
}
