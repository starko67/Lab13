package lab13;
import java.util.Scanner;

public class PhoneNumberConverter {
    public static String convertPhoneNumber(String phoneNumber) {
        // Удаление всех символов, кроме цифр
        String numericPhoneNumber = phoneNumber.replaceAll("\\D", "");

        if (numericPhoneNumber.length() == 11) {
            // Формат: +<Код страны><Номер 10 цифр>
            String countryCode = numericPhoneNumber.substring(1, 4);
            String areaCode = numericPhoneNumber.substring(4, 7);
            String localNumber = numericPhoneNumber.substring(7,11);
            return String.format("+7%s-%s-%s", countryCode, areaCode, localNumber);
        } else if (numericPhoneNumber.length() == 10) {
            // Формат: 8<Номер 10 цифр> для России
            return String.format("+%s-%s-%s", numericPhoneNumber.substring(0, 3), numericPhoneNumber.substring(3, 6), numericPhoneNumber.substring(6,10));
        } else {
            return "Некорректный номер";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber=scanner.next();
        String convertedPhoneNumber = convertPhoneNumber(phoneNumber);
        System.out.println(convertedPhoneNumber);

    }
}