package task_3;

import task_3.Exceptions.ParseException;
import task_3.Exceptions.UserEx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class UserConsoleReader implements UserReader {
    private Scanner scanner;

    public UserConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public User readUser() throws UserEx {
        while (true) {
            System.out.println("Введите данные: Фамилия Имя Отчество Дата рождения (dd.mm.yyyy) Номер телефона Пол (f или m)");

            try {
                String input = scanner.nextLine();
                String[] data = input.split(" ");

                if (data.length != 6) {
                    throw new UserEx("Введено неверное количество данных");
                }

                LocalDate dateOfBirth = parseDateOfBirth(data[3]);
                long phoneNumber = parsePhoneNumber(data[4]);
                Sex sex = parseSex(data[5]);

                return new User(data[0], data[1], data[2], dateOfBirth, phoneNumber, sex);
            } catch (ParseException | NumberFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private LocalDate parseDateOfBirth(String dateOfBirthString) throws ParseException {
        try {
            return LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new ParseException("Неверный формат даты рождения");
        }
    }

    private long parsePhoneNumber(String phoneNumberString) throws ParseException {
        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new ParseException("Неверный формат номера телефона");
        }
    }

    private Sex parseSex(String sexString) throws ParseException {
        if (sexString.equalsIgnoreCase("m")) {
            return Sex.MALE;
        } else if (sexString.equalsIgnoreCase("f")) {
            return Sex.FEMALE;
        } else {
            throw new ParseException("Неверный формат пола");
        }
    }
}
